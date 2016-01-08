# SnowView
雪花效果
### Sample
 ![sample1 gif](/png/sample1.gif)
 ![sample2 gif](/png/sample2.gif)
#### 设置属性
    snow_level      //雪的大小
    snow_color      //雪花的颜色
    snow_flake_type //雪花类型（纯色或者自定义图片）
    默认为match_parent.

#### 代码中设置

    snowView.setSnowLevel(...);   //HUGESNOW,BIGSNOW,MIDDLESNOW,SMALLSNOW

    snowView.setSnowColor(...);
    //如果想让雪花显示为图片的话，暂时只支持代码中添加bitmap
    snowView.setSnowFlakeBitmap(snowFlakeBitmap);

> 其他属性及截图待续。
