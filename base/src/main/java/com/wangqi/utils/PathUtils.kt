package com.wangqi.utils

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.TextUtils

object PathUtils {
    fun convertUriToPath(context: Context, uri: Uri?): String? {
        if (uri == null) {
            return null
        }
        val schema = uri.scheme
        if (TextUtils.isEmpty(schema) || ContentResolver.SCHEME_FILE == schema) {
            return uri.path
        }
        if ("http" == schema) {
            return uri.toString()
        }
        // DocumentProvider
        if (DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (TextUtils.equals("com.android.externalstorage.documents", uri.authority)) {
                val docId = DocumentsContract.getDocumentId(uri)
                val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val type = split[0]

                if ("primary".equals(type, ignoreCase = true)) {
                    return Environment.getExternalStorageDirectory().toString() + "/" + split[1]
                }
            } else if (TextUtils.equals("com.android.providers.downloads.documents", uri.authority)) {
                // DownloadsProvider
                val id = DocumentsContract.getDocumentId(uri)
                val contentUri = ContentUris.withAppendedId(
                    Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(id)
                )

                return getDataColumn(context, contentUri, null, null)
            } else if (TextUtils.equals("com.android.providers.media.documents", uri.authority)) {
                // MediaProvider
                val docId = DocumentsContract.getDocumentId(uri)
                val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val type = split[0]

                var contentUri: Uri? = null
                if (TextUtils.equals("image", type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                } else if (TextUtils.equals("video", type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                } else if (TextUtils.equals("audio", type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                }

                val selection = "_id=?"
                val selectionArgs = arrayOf(split[1])

                return getDataColumn(
                    context,
                    contentUri,
                    selection,
                    selectionArgs
                )
            }
        }
        if (ContentResolver.SCHEME_CONTENT == schema) {
            val projection = arrayOf(MediaStore.MediaColumns.DATA)
            var cursor: Cursor? = null
            var filePath = ""
            try {
                cursor = context.contentResolver.query(uri, projection, null, null, null)
                if (cursor!!.moveToFirst()) {
                    filePath = cursor.getString(0)
                }
                cursor?.close()
            } catch (e: Exception) {
                // do nothing
            } finally {
                try {
                    cursor?.close()
                } catch (e2: Exception) {
                    // do nothing
                }

            }
            if (TextUtils.isEmpty(figit lePath)) {
                try {
                    val contentResolver = context.contentResolver
                    val selection = MediaStore.Images.Media._ID + "= ?"
                    var id = uri.lastPathSegment
                    if (!TextUtils.isEmpty(id) && id!!.contains(":")) {
                        id = id.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                    }
                    val selectionArgs = arrayOf<String>(id!!)
                    cursor = contentResolver.query(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, selection,
                        selectionArgs, null
                    )
                    if (cursor!!.moveToFirst()) {
                        filePath = cursor.getString(0)
                    }
                    cursor?.close()

                } catch (e: Exception) {
                    // do nothing
                } finally {
                    try {
                        cursor?.close()
                    } catch (e: Exception) {
                        // do nothing
                    }

                }
            }
            return filePath
        }
        return null
    }

    private fun getDataColumn(
        context: Context, uri: Uri?, selection: String?,
        selectionArgs: Array<String>?
    ): String? {

        var cursor: Cursor? = null
        val column = "_data"
        val projection = arrayOf(column)

        try {
            cursor = context.contentResolver.query(uri!!, projection, selection, selectionArgs, null)
            if (cursor != null && cursor.moveToFirst()) {
                val index = cursor.getColumnIndexOrThrow(column)
                return cursor.getString(index)
            }
        } finally {
            cursor?.close()
        }
        return null
    }
}