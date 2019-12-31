#FDialogFragment
封装FDialogFragment简化弹窗dialog使用

![image](https://github.com/sooola/FDialogFragment/blob/master/screenshot/GIF.gif)

# 导入

1.在根目录的build.gradle

```java
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

2.在项目build.gradle

```java
	dependencies {
	        implementation 'com.github.sooola:FDialogFragment:1.0
    }
```

# 使用

所有dialog 通过DialogBuildUtil 构建

1.简单的确认dialog  
![image](https://github.com/sooola/FDialogFragment/blob/master/screenshot/1.png)

```java
DialogBuildUtil.showSimpleConfirmDialog(getSupportFragmentManager(), "test111", new FDialogInterface.OnClickConfirmListener() {
    @Override
    public void onClickConfirm(DialogInterface dialog, int id) {
        Toast.makeText(MainActivity.this, "sure", Toast.LENGTH_SHORT).show();
    }
}, new FDialogInterface.OnClickCancelListener() {
    @Override
    public void onClickCancel(DialogInterface dialog, int id) {
        Toast.makeText(MainActivity.this, "cancle", Toast.LENGTH_SHORT).show();
    }
});
```

2.列表dialog  
![image](https://github.com/sooola/FDialogFragment/blob/master/screenshot/2.png)

```java
DialogBuildUtil.showListDialog(getSupportFragmentManager(), "城市列表", city, new FDialogInterface.OnDataCallbackListener() {
    @Override
    public boolean onDataCallback(int which) {
        Toast.makeText(MainActivity.this, "list click " + which, Toast.LENGTH_SHORT).show();
        return false;
    }
});
```

3.单选列表
![image](https://github.com/sooola/FDialogFragment/blob/master/screenshot/3.png)

```java
DialogBuildUtil.showSingleChoiceDialog(getSupportFragmentManager(), "城市列表", city, new FDialogInterface.OnDataCallbackListener() {
    @Override
    public boolean onDataCallback(int which) {
        Toast.makeText(MainActivity.this, "list click " + which, Toast.LENGTH_SHORT).show();
        return false;
    }
});
```

4.多选列表
![image](https://github.com/sooola/FDialogFragment/blob/master/screenshot/4.png)

```java
DialogBuildUtil.showMulChoiceDialog(getSupportFragmentManager(), "城市列表", city, new FDialogInterface.OnMulCallbackListener() {
    @Override
    public boolean onMulDataCallback(List<Integer> selectItems) {

        Toast.makeText(MainActivity.this, "list click " + selectItems, Toast.LENGTH_SHORT).show();
        return false;
    }
});
```

5.加载中dialog

```java
final CommonDialog loadingDialog = DialogBuildUtil.showLoadingDialog();
loadingDialog.show(getSupportFragmentManager() ,DialogBuildUtil.LOADING_TAG);
```

