package cn.itcast.douban.site;

public class SinaSite extends Site {

	protected void onConstruct(){
		name="新浪微博";
		initFaceMap();
	}

	private void initFaceMap(){
		faceMap.put("[呵呵]", "hehe");
		faceMap.put("[嘻嘻]", "xixi");
		faceMap.put("[哈哈]", "haha");
		faceMap.put("[爱你]", "aini");
		faceMap.put("[晕]", "yun");
		faceMap.put("[泪]", "lei");
	}
}