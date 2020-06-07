package cn.itcast.douban;

public class Chat {
    private String chatName,chatText,chatTime;
    private int chatImg;
    Chat(int chatImg, String chatName, String chatText, String chatTime){
        this.chatImg=chatImg;//头像
        this.chatName=chatName;//名字
        this.chatText=chatText;//聊天记录文字
        this.chatTime=chatTime;//时间
    }
    String getChatTime(){
        return chatTime;
    }
    String getChatName(){
        return chatName;
    }
    String getChatText(){
        return chatText;
    }
    int getChatImg(){
        return chatImg;
    }
}
