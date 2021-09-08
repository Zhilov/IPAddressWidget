package com.example.myapplication.Widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;

import com.example.myapplication.R;
import com.example.myapplication.Utils;

@RequiresApi(api = Build.VERSION_CODES.S)
public class IPWidgetDark extends AppWidgetProvider {

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        RemoteViews widgetView = new RemoteViews(context.getPackageName(),
                R.layout.ip_widget_dark);
        widgetView.setTextViewText(R.id.text_ip_widget_dark, Utils.getIPAddress(true));
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews widgetView = new RemoteViews(context.getPackageName(),
                R.layout.ip_widget_dark);
        widgetView.setTextViewText(R.id.text_ip_widget_dark, Utils.getIPAddress(true));
        appWidgetManager.updateAppWidget(appWidgetIds[0], widgetView);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

}
