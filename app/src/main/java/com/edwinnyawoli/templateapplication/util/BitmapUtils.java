/*
 * Copyright 2018 Edwin Nyawoli
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.edwinnyawoli.templateapplication.util;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import timber.log.Timber;

import static android.util.Base64.DEFAULT;

/**
 *
 */

public class BitmapUtils {

    public static String base64PNGEncodeBitmap(Bitmap bitmap) {
        if (bitmap == null)
            return null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 65, baos);
        byte[] bitmapByteArray = baos.toByteArray();

        return Base64.encodeToString(bitmapByteArray, DEFAULT);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static int getImageOrientation(String imagePath) {
        int rotate = 0;
        try {
            ExifInterface exif = new ExifInterface(imagePath);
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }
        } catch (IOException e) {
            Timber.e(e);
        }

        return rotate;
    }

    public static String base64PNGEncodeScaledBitmap(Bitmap bitmap,
                                                     int scaledWidth,
                                                     int scaledHeight) throws OutOfMemoryError {
        if (bitmap == null)
            return null;

        scaledWidth = Math.max(scaledWidth, 350);
        scaledHeight = Math.max(scaledHeight, 350);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap,
                scaledWidth, scaledHeight, true);

        System.gc();

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 65, baos);
            byte[] bitmapByteArray = baos.toByteArray();

            if (!scaledBitmap.isRecycled())
                scaledBitmap.recycle();
            return Base64.encodeToString(bitmapByteArray, DEFAULT);
        } catch (OutOfMemoryError e) {
            Timber.e(e);
            return base64PNGEncodeSmallerScaledBitmap(scaledBitmap, 350, 350);
        }
    }

    public static String base64PNGEncodeSmallerScaledBitmap(Bitmap scaledBitmap,
                                                            int scaledWidth,
                                                            int scaledHeight) throws OutOfMemoryError {
        if (scaledBitmap == null)
            return null;

        System.gc();

        ByteArrayOutputStream baos = new ByteArrayOutputStream(250);
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] bitmapByteArray = baos.toByteArray();
        scaledBitmap.recycle();
        return Base64.encodeToString(bitmapByteArray, DEFAULT);
    }

    public static Bitmap decodeBase64PNGEncodedBitmap(String base64PNGEncodedImage) {
        if (!TextUtils.isEmpty(base64PNGEncodedImage)) {
            byte[] decodedSignature;

            decodedSignature = Base64.decode(base64PNGEncodedImage, DEFAULT);

            return BitmapFactory.decodeByteArray(decodedSignature, 0, decodedSignature.length);
        }

        return null;
    }

    public static String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj,
                    null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } catch (Exception e) {
            Timber.e("getRealPathFromURI Exception : " + e.toString());
            return "";
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
