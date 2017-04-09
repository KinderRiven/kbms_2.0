package com.upsuns.function;

/*
 * Created by KinderRiven on 2017/4/9.
 */
public class CropperUtils {

    private int x, y, width, height, sid;

    public void parseJson(String json){

        String name = "";
        String number = "";
        int pos = 0;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            if (c == '{' || c == ':')
                continue;

            if (c == '"') {
                pos++;
            } else if (c == ',' || c == '}') {
                if (name.equals("x")) {
                    x = (int) Double.parseDouble(number);
                }
                else if (name.equals("y")) {
                    y = (int) Double.parseDouble(number);
                }
                else if (name.equals("width")) {
                    width = (int) Double.parseDouble(number);
                }
                else if (name.equals("height")) {
                    height = (int) Double.parseDouble(number);
                }
                else if(name.equals("sid")){
                    if(number.charAt(0) <= '0' || number.charAt(0) >= '9');
                    else
                        sid = (int) Double.parseDouble(number);
                }
                name = "";
                number = "";
            } else {
                if (pos % 2 == 1)
                    name = name + c;
                else if (pos % 2 == 0)
                    number = number + c;
            }
        }
        System.out.println("Cropper" + " x:" + x + " y:" + y + " width:" + width
              + " height:" + height + " sid:" + sid);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
