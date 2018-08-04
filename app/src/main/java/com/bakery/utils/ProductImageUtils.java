package com.bakery.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bakery.BuildConfig;
import com.bakery.data.network.models.ProductResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public final class ProductImageUtils {

    private ProductImageUtils() {

    }

    public static void loadImage(Context context, ImageView imageView, ProductResponse response) {
        if(response.getMediaGalleryEntries().size() > 0) {
            loadGalleryImage(context, imageView, response.getMediaGalleryEntries());
        } else if(response.getCustomAttributes().size() > 0){
            loadAttributeImage(context, imageView, response.getCustomAttributes());
        }
    }

    public static void loadGalleryImage(Context context, ImageView imageView, List<ProductResponse.MediaGalleryEntry> mediaGalleryEntries) {
        String url = mediaGalleryEntries.get(0).getFile();
        loadImage(context, imageView, url);
    }

    public static void loadAttributeImage(Context context, ImageView imageView, List<ProductResponse.CustomAttribute> customAttributes) {
        for(ProductResponse.CustomAttribute customAttribute : customAttributes) {
            if(customAttribute.getAttributeCode().equals("thumbnail")) {
                loadImage(context, imageView, String.valueOf(customAttribute.getValue()));
                break;
            }
        }
    }

    public static void loadImage(Context context, ImageView imageView, String url) {
        if(!url.equals("")) {
            Picasso.with(context)
                    .load(Uri.parse(BuildConfig.BASE_URL + "/pub/media/catalog/product"+ url))
                    .into(imageView);
        }
    }
}
