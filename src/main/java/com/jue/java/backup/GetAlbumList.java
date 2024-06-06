package com.jue.java.backup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetAlbumList {

    public static final boolean STORE = false;

    public static final String COOKIE = "_iuqxldmzr_=32; _ntes_nuid=2f6603aee261b3095316e2583bc19040; WM_TID=JG%2FouDrt6ZhAVUFUBQYrFe8WHuz%2BZut4; nts_mail_user=wangjueya@163.com:-1:1; WEVNSM=1.0.0; WNMCID=zpfdvo.1641644090946.01.0; NMTID=00OPx2TFS92TyGvp0NBuhSKlPF2gpgAAAF-OZzqjg; ntes_kaola_ad=1; _ntes_nnid=2f6603aee261b3095316e2583bc19040,1711458058528; ntes_utid=tid._.16Rn19rW9AxFBhEBBBOBrvDt83CXHs18._.0; sDeviceId=YD-y%2BwEnjz3CT5EV0QBBQeF79uYSVJ16nco; JSESSIONID-WYYY=aHK%2FUOrvXdoa%2F%2BBvxSAchoHjN8NcRY%2BRYVAyy6fEsHrw%2B%5CucK%5CSMoEjEa7agiMlFEQ8z%2FiMzXH3a1f3YqfzJpovo%2BuTxhFlcw9Q2uz0eCzfP6UXlO%2F7RmA4ND3OK1gNWtj6MPTtUOiSJSejH2uSckdDGDcWZA4G13ksqhxsxCv5y3hUb%3A1717300557255; WM_NI=7t4TbkUbxPUTAE8%2FyzSqwXPbu7Oh2YsIQCgaLRG3B6lqyGevcm9sJyGWTfhNiw%2BGjOMpfG5k%2FpiI%2Bg%2FPi602DXSOPE%2Fi9d17vem6jSjGNopiC98pdxvU7%2BqFGjtCMsbWNFM%3D; WM_NIKE=9ca17ae2e6ffcda170e2e6eed9d77e8f92b8a4db698f9a8fb2d14f829f9eadc57af6bdbc93b779edeaf991ef2af0fea7c3b92af5acfcb5e16197beb8b1d860839bf8d0fc7291afb9b9d36ab7e98189b153b1979fa4e66b908e89d4c13eb0afb7a8e87ea1b3f794c97385899c87eb46aba9e5a8e9458fb0aaa8b861edb0a7aaaa6ded90a7d7b33a88889db0d34fedb7f785b43db6bba3d7e959aa998290f36381e7f891e774b68bf9ccf44e85b6bca4d079a28982a7d037e2a3; __snaker__id=9aNDF9Pl9yIxZXHo; gdxidpyhxdE=q34LcKKD%2BafVZBomj4%2BDNmgB4pK3PvzkKMiEEdZPOEe2GbYAcagpIA9%5C%5ClhSt9g3M85v%2FLaTjGJv2JYzd1KeUfruZZ6uJz9bd%5CZo7ZBMmSpvY0z16b0LlLoI%5CieCSfQZdwqV6O6BRjGbw0rNCB%5C9NxNVXTYWMyYauRtMYTe3ZO4Y52EZ%3A1717299669696; NTES_YD_SESS=HbmXtT9sxrgqp6qkJnjeXmeAOcl5s1EIH3IdDtwiDBo7FjMNF3qU1PxhO6u7v48FKoEYTDGzib_GIsdeB17xvCi2OBcDF0hWnckfIgWZdyb6dRJedUeX9UJ_Q6l5aTLpwR_tRb.1k7067VuzeQN6iBbA5TaWE7XlIn.JE6SXXM5OQgvPw8LSu_XXDEQzgWiwzjK3C2dx5i7yO04u0vBuMhns.np_Dix5EVQ6PptuH0vz6; S_INFO=1717298798|0|0&60##|16619778424; P_INFO=16619778424|1717298798|1|music|00&99|null&null&null#bej&null#10#0|&0||16619778424; __csrf=6aafafd96dda2de3000d60046ac13602; __remember_me=true; MUSIC_U=0057D2C99E730D028BCE961266EB371B2E641358F4EAD469C40E5361C443AC6C24DE7F89D804013E4C1047900B10E023EA8AAD603C954EE32885FA24D879D80C126CB3F0231360EECE8294E9B49E096AB544F7D7BB3E3DBE704DE822E350414919B0CC870CCCF3B3CA0B355C773A577D2166995AF247B5C65219EB9585D99716A9D29A35AA103EDAF07E7895EEDADB700743072B3A0BDDF60CC716B0836448F24687216804226BE6B5E8B93BC34EEEF9CD8DB7C03BD1D24A8A72E95FB9B45EE5189D0719ACCC8F114684B7FE68278DC38A69A179E05E5BD37AE2A9E6252F270CEDA3AC4B0623E712B32D80623BBD157BE2F9D9DBAA6989CC77BDCD9E2A6929EE7F43FC8B30D30512105B7992C64928DB719CA4AAB350D678A45ECDE20FEAF9E787D4BC3C6C19DC5A6DDD516559980D4D0C49CB082A615D36FF13729656FDF8C1D94107FB366856B55BB32527DAD87E2FA2AE349F0BDADA8F8A77D39DBC8B0DD17B";

    public static void main(String[] args) throws IOException {
        String[][] item = new String[][]{
                {null, null}
                , {"2116", "1974-陈奕迅"}
                , {"6452", "1979-周杰伦"}
                , {"7219", "1980-蔡依林"}
                , {"5771", "1986-许嵩"}
                , {"7763", "1991-G.E.M.邓紫棋"}
                , {"12709", "2000-S.H.E"}
                , {"12438", "2004-南拳妈妈"}
                , {"10200", "1983-郁可唯"}
                , {"30802803", "1997-咻咻满"}
                , {"1030001", "1992-周深"}
                , {"5781", "1983-薛之谦"}
                , {"4292", "1985-李荣浩"}
                , {"10198", "1974-杨乃文"}
                , {"5538", "1989-汪苏泷"}
                , {"7890", "1987-黄龄"}
                , {"3249", "1984-河图"}
                , {"7652", "1976-范玮琪"}
                , {"7762", "1986-郭采洁"}
                , {"12359437", "1989-李常超 (Lao乾妈)"}
                , {"4130", "1978-李玉刚"}
                , {"3684", "1981-林俊杰"}
                , {"8338", "1987-刘亦菲"}
                , {"1161201", "2014-满汉全席"}
                , {"8259", "1981-金莎"}
                , {"3066", "1983-胡彦斌"}
                , {"10572", "1983-张芸京"}
                , {"29802127", "2001-单依纯"}
                , {"6462", "1981-张敬轩"}
                , {"188565", "1991-银临"}
                , {"6290", "1980-音频怪物"}
                , {"188558", "1986-Aki阿杰"}
                , {"8926", "1970-莫文蔚"}
                , {"961358", "1992-不才"}
                , {"9061", "1967-那英"}
                , {"64143", "1978-Lenka"}
                , {"12186038", "1998-叶炫清"}
                , {"10371", "1981-姚贝娜"}
                , {"13193", "1999-五月天"}
                , {"1047237", "1993-五音Jw"}
                , {"12083175", "1994-排骨教主"}
                , {"4592", "1989-马頔"}
                , {"3685", "1987-林宥嘉"}
                , {"8325", "1987-梁静茹"}
                , {"8327", "1984-李宇春"}
                , {"3121", "1983-黄阅"}
                , {"16456", "1989-花澤香菜"}
                , {"189955", "1990-蔡翊昇"}
                , {"791534", "1979-戴荃"}
                , {"791100", "1987-陈姿彤"}
                , {"10763", "1984-曾沛慈"}
                , {"12985", "2000-Twins"}
                , {"797087", "1988-Smile_小千"}
                , {"11952", "2004-JS"}
                , {"11679", "2004-GALA"}
        };
        List<String[]> infos = new ArrayList<>();
        for (String[] i : item) {
            try {
                infos.addAll(create(STORE, i[0], i[1]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!STORE) {
            write(new File("D:/code/basic-java/src/main/resources/music/index.md"),
                    "| 歌手 | 歌名 | 存储路径 | 是否存在 |\n| :--- | :--- | :--- | :---: |\n" +
                            infos.stream().map(line -> "| " + String.join(" | ", line) + " |").collect(Collectors.joining("\n")));
        }
    }

    public static List<String[]> create(boolean store, String userId, String userName) throws IOException {
        List<String[]> res = new ArrayList<>();
        if (userId == null || userName == null) {
            return res;
        }
        // 创建内容
        String folder = "D:/code/basic-java/src/main/resources/music/" + userId;
        boolean success = new File(folder).mkdir();
        if (!success) {
            System.out.println(folder + "  >>>>  已创建");
        }

        String storeFolderPath = "Z:/" + userName;
        if (store && new File(storeFolderPath).mkdir()) {
            System.out.println(storeFolderPath + "  >>>>  已创建");
        }

        // 处理专辑数据
        File file = new File(folder + "/index.html");
        Document doc;
        if (file.exists()) {
            doc = Jsoup.parse(file, "utf-8", "");
        } else {
            doc = getHtml(String.format("https://music.163.com/artist/album?id=%s&limit=1000", userId));
            if (file.createNewFile()) {
                Elements parent = doc.getElementsByAttributeValueStarting("data-id", userId);
                write(file, parent.outerHtml());
            }
        }
        if (doc == null) {
            return res;
        }

        // 处理歌曲数据
        Elements parent = doc.getElementsByAttributeValueStarting("data-id", userId);

        for (Element child : parent.get(0).children()) {
            String date = child.getElementsByClass("s-fc3").text();
            Elements album = child.getElementsByClass("tit s-fc0");
            String name = album.text().replaceAll("/", "&");
            while (name.endsWith(".")) {
                name = name.substring(0, name.length() - 1);
            }
            String href = album.get(0).attributes().get("href");
            String albumId = href.split("id=")[1];
            String[] dd = date.split("\\.");
            date = dd[0] + (dd[1].length() == 1 ? ".0" : ".") + dd[1] + (dd[2].length() == 1 ? ".0" : ".") + dd[2];

            String folderPath = storeFolderPath + "/" + date + "-" + name;
            try {
                if (store && new File(folderPath).mkdir()) {
                    System.out.println(folderPath + "  >>>>  成功");
                }

                File albumFile = new File(folder + "/" + albumId + ".html");
                Document albumDoc;
                if (albumFile.exists()) {
                    albumDoc = Jsoup.parse(albumFile, "utf-8", "");
                } else {
                    albumDoc = getHtml("https://music.163.com/album?id=" + albumId);
                    if (albumFile.createNewFile()) {
                        Element element = albumDoc.getElementById("song-list-pre-cache");
                        write(albumFile, element.outerHtml());
                    }
                }

                Elements elements = albumDoc.getElementById("song-list-pre-cache").getElementsByTag("a");
                for (Element music : elements) {
                    // 列出专辑歌曲
                    String musicName = music.text().trim().replaceAll(" / ", "&").replaceAll("/", "&");
                    String musicPath = folderPath + "/" + musicName + ".mp3";
                    String[] infoItem = new String[]{userName, musicName, musicPath, "404"};
                    res.add(infoItem);

                    File musicFile = new File(musicPath);
                    File musicBkFile = new File(musicPath + ".bk");
                    if (!musicFile.exists()) {
                        if (store) {
                            System.out.println(musicPath + "  >>>>  遍历");
                            if (musicBkFile.createNewFile()) {
                                write(musicBkFile, music.text());
                            }
                        }
                    } else {
                        musicBkFile.deleteOnExit();
                        infoItem[3] = "exists";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(folderPath + "  >>>>  失败");
            }
        }
        return res;
    }

    public static void write(File file, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.close();
    }

    public static Document getHtml(String url) {
        Document res = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            // 设置请求方法
            connection.setRequestMethod("GET");
            // 设置请求头
            connection.setRequestProperty("Cookie", COOKIE);
            // 发送请求
            connection.connect();
            // 检查响应码
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                res = Jsoup.parse(connection.getInputStream(), StandardCharsets.UTF_8.name(), "");
            }
            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
