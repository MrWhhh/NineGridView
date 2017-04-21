# NineGridView
微信微博空间相册控件

使用方法很简单，大家可下载demo，根据自己需求更改。喜欢的star......

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.MrWhhh:NineGridView:1.0.0'
	}
  
  # 九宫格样式
  ![image](https://github.com/MrWhhh/NineGridView/raw/master/GIF.gif)
  
  # 自定义样式
  ![image](https://github.com/MrWhhh/NineGridView/raw/master/GIF2.gif)
  
  # 使用方式
  
        holder.nineGridView.setShowStyle(showStyle);
        holder.nineGridView.setAdapter(new NineGridViewAdapter<TalkInfo.PhotoInfo>() {
            @Override
            public void loadingWayImg(Context context, ImageView imageView, TalkInfo.PhotoInfo data) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, data.ids));
            }

            @Override
            public void onItemClick(Context context, ImageView imageView, int position, List<TalkInfo.PhotoInfo> list) {
                Toast.makeText(context, "点击图第" + position + "图片", Toast.LENGTH_LONG).show();
            }
        });
        holder.nineGridView.setData(list.get(position).photo);
        
        
 # Adapter说明
     /**
     * 加载图片到ImageView
     *
     * @param context
     * @param imageView
     * @param t
     */
    public abstract void loadingWayImg(Context context, ImageView imageView, T t);

    /**
     * item点击事件
     *
     * @param context
     * @param imageView
     * @param position
     * @param list
     */
    public abstract void onItemClick(Context context, ImageView imageView, int position, List<T> list);

    /**
     * 实例化ImageView onTouch事件加了点击效果 也可以自定义
     *
     * @param context
     * @return
     */
    public ImageView getImageView(Context context);
    
    
使用方法很简单，大家可下载demo，根据自己需求更改。喜欢的star......
