# FDialogFragment
封装DialogFragment简化弹窗的使用


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
