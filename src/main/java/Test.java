import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

 class Test {

    private static int fibonacci(int n){
        if(n<0) return 1;
        if(n<=1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    static String topic = "pizza";

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String urlString = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page="+topic.replaceAll(" ", "%20");
        URL url = null;
        HttpURLConnection con = null;
        try {
            url = new URL(urlString);
           con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
                String newLine =line.replaceAll("\"", " ").replaceAll("\\\\","");
                System.out.println("newLine = " + newLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != con){
                try{
                    con.disconnect();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        Gson gson = new Gson();
        WikiVO wikiVo = gson.fromJson(sb.toString(), WikiVO.class);
//        System.out.println("wikiVo = " + wikiVo);
        String a  = wikiVo.getParse().getText().get("*").toString()
                .replaceAll("\\<.*?\\>", "")
                .replaceAll("\\\\n", " ")
                .replaceAll("(" + topic+")","");
        String aa[]  = a .split(" ");
        int count = (int) Arrays.stream(aa).filter(s -> {
            if(s.contains(topic)){
                System.out.println("s = " + s);
                return true;
            }
            return false;
        }).count();
        System.out.println("count = " + count);
    }
}
class WikiVO{
    private WikiPage parse;

    public WikiPage getParse() {
        return parse;
    }

    public void setParse(WikiPage parse) {
        this.parse = parse;
    }

    @Override
    public String toString() {
        return "{" +
                "parse=" + parse +
                '}';
    }
}
class WikiPage{
    private String title;
    private Integer pageid;
    private JsonObject text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageId(Integer pageid) {
        this.pageid = pageid;
    }

    public JsonObject getText() {
        return text;
    }

    public void setText(JsonObject text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", pageId=" + pageid +
                ", text='" + text + '\'' +
                '}';
    }
    private static class Abc{
        String hello;
    }
}

