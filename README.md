# Demo-Sigma-Interactive-AndroidTV
# SigmaInteractive SDK

## Requirement: Android minSdk 21, Exoplayer 2.17.+

### I. Cài đặt

Thêm file [SigmaInteractiveTVSDK.aar](https://github.com/truongnguyen1804/Demo-Sigma-Interactive-AndroidTV/tree/master/libs) vào thư mục libs cùng cấp với thư mục app của project.

Thêm vào app/build.gradle:

```
dependencies {
   ...
   implementation files('../libs/SigmaInteractiveTVSDK.aar')

}
```

### II. Sử dụng

1. Thêm SigmaInteractive sdk vào project (mục **I**).

2. Thêm sự kiện lắng nghe khi id3 bắt đầu parse để gửi dữ liệu cho sdk tương tác

   [SigmaRendererFactory](https://github.com/phamngochai123/sigma-interactive-sdk-example/blob/mobile-android/app/src/main/java/com/example/sigmainteractive/SigmaRendererFactory.java) xem trong demo

   ```java
   DefaultRenderersFactory renderersFactory = new SigmaRendererFactory(this, metadata -> {
             if (metadata != null) {
                 for (int i = 0; i < metadata.length(); i++) {
                     Metadata.Entry entry = metadata.get(i);
                     if (entry instanceof TextInformationFrame) {
                         String des = ((TextInformationFrame) entry).description;
                         String value = ((TextInformationFrame) entry).value;
                         if (des.toUpperCase().equals("TXXX")) {
                             _interactiveWebview.sendID3TagInstant(value);
                         }
                     }
                 }
             }
         });
   
   exoPlayer = new ExoPlayer.Builder(this, renderersFactory).build();
   
   ```

3. Thêm sự kiện lắng nghe khi id3 trả ra đúng thời điểm hẹn giờ để gửi dữ liệu cho sdk tương tác

   ```java
    exoPlayer.addAnalyticsListener(new AnalyticsListener() {
               @Override
               public void onMetadata(EventTime eventTime, Metadata metadata) {
                   Log.d("checkListener", new Gson().toJson(metadata));
                   if (metadata != null) {
                       for (int i = 0; i < metadata.length(); i++) {
                           Metadata.Entry entry = metadata.get(i);
                           if (entry instanceof TextInformationFrame) {
                               String des = ((TextInformationFrame) entry).description;
                               String value = ((TextInformationFrame) entry).value;
                               if (des.toUpperCase().equals("TXXX")) {
                                   _interactiveWebview.sendID3Tag(value);
                               }
                           }
                       }
                   }
               }
           });
   ```

4. Tạo SigmaWebViewCallback để lắng nghe các sự kiện từ sdk tương tác.

   4.1 Trong hàm onReady gửi dữ liệu dạng json string cho sdk tương tác (bắt buộc)

   ```
   _interactiveWebview.sendOnReadyBack(new Gson().toJson(getUserOption(token, currrentChannelId)));
   ```

   4.2 Trong hàm onKeyDown lắng nghe các sự kiện phím trả về từ webview và xử lý các sự kiện đó.

   ```java
                 @Override
               public void onKeyDown(int code) {
                   Log.d("_interactiveWebview", "onKeyDown " + code);
   
                   KeyEvent event = null;
   
                   switch (code) {
                       case SigmaWebView.KEYCODE_UP:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_UP);
                           break;
                       case SigmaWebView.KEYCODE_DOWN:
                       
                           btnGuest.requestFocus();
                           ((WebView) _interactiveWebview).setFocusable(true);
                           ((WebView) _interactiveWebview).clearFocus();
                           break;
                       case SigmaWebView.KEYCODE_LEFT:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_LEFT);
                           break;
                       case SigmaWebView.KEYCODE_RIGHT:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_RIGHT);
                           break;
                       case SigmaWebView.KEYCODE_ENTER:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER);
                           break;
                       case SigmaWebView.KEYCODE_ESCAPE:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK);
                           break;
                       case SigmaWebView.KEYCODE_0:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_0);
                           break;
                       case SigmaWebView.KEYCODE_1:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_1);
                           break;
                       case SigmaWebView.KEYCODE_2:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_2);
                           break;
                       case SigmaWebView.KEYCODE_3:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_3);
                           break;
                       case SigmaWebView.KEYCODE_4:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_4);
                           break;
                       case SigmaWebView.KEYCODE_5:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_5);
                           break;
                       case SigmaWebView.KEYCODE_6:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_6);
                           break;
                       case SigmaWebView.KEYCODE_7:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_7);
                           break;
                       case SigmaWebView.KEYCODE_8:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_8);
                           break;
                       case SigmaWebView.KEYCODE_9:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_9);
                           break;
                       case SigmaWebView.KEYCODE_PAGEUP:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_PAGE_UP);
                           break;
                       case SigmaWebView.KEYCODE_PAGEDOWN:
                           event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_PAGE_DOWN);
                           break;
                   }
   
                   if (event != null) {
                       PlayerActivity.this.onKeyDown(event.getKeyCode(), event);
                   }
               }
   ```

   

#### 



