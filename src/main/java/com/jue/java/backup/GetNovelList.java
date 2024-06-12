package com.jue.java.backup;

import com.jue.java.backup.entity.DataNovel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetNovelList {

    public static final String COOKIE = "novel_version=201602181156; bbsnicknameAndsign=2%257E%2529%2524%25E7%258F%258F; timeOffset_o=-746; testcookie=yes; Hm_lvt_bc3b748c21fe5cf393d26c12b2c38d99=1717315358,1717512627; smidV2=2021061319181007ed79772a9b4d02121e261be1c571c200000a0f9146dab90; JJSESS=%7B%22returnUrl%22%3A%22//my.jjwxc.net/backend/favoriteauthor.php%3Fjsid%3D24212016-0.10855060873694389%26from%3Dlogininfo%22%2C%22sidkey%22%3A%22J7NY0SG2qo9hLE4ea8DAdT6FOvMtURj3BlxnWI%22%7D; token=MjQyMTIwMTZ8NmE3MTFkM2ZkMjZiZDVhOTRlM2E1YWE4MDZlNGJjZjh8fHw1MDI1MzcwfDI1OTIwMDB8MXzoib7ojJzojJx8fOaZi%2Baxn%2BeUqOaIt3wxfG1vYmlsZXwxfDB8fA%3D%3D; bbstoken=MjQyMTIwMTZfMF9lMzc5MzVlNGJmODM5Mzk2NzlmZGY5N2JkNmQ1YzIyYV8xX19zS3pjNTl6bl8x; Hm_lpvt_bc3b748c21fe5cf393d26c12b2c38d99=1717512686; JJEVER=%7B%22isKindle%22%3A%22%22%2C%22login_check_sign%22%3A%223dc047def636afeed9592db47126e06e%22%2C%22desid%22%3A%22Dc1x4tZSHJeYAnf0eeNtM43f8SJBBaV2%22%2C%22user_signin_days%22%3A%22%22%2C%22lastCheckLoginTimeWap%22%3A1717512542%2C%22nicknameAndsign%22%3A%222%257E%2529%2524%25E7%258F%258F%22%2C%22foreverreader%22%3A%2224212016%22%2C%22sms_total%22%3A%220%22%2C%22lastCheckLoginTimePc%22%3A1717512678%2C%22fenzhan%22%3A%22by%22%2C%22shumeideviceId%22%3A%22WHJMrwNw1k/FL2EiIdtk8Ts7zDEmHPhVu35uTQgJfiRPedR788s+x4+9Obub7kwnzk/N6ikpfnSIeLMtRADa8A98FpfuNL2hZdCW1tldyDzmQI99+chXEioZvf5Kho8XE27A54gDgTBk3vaAoz2wRe0lBLaZv6y0KU10Rt18csPbSczD/UEAZLtLRGablCVRfbh4vSnbcMzY2bCBM9cOgFYuZGshxoMcuebF/HklHT5AzH6l3uOHGNQUDic6AW2yIixSMW2OQhYo%3D1487582755342%22%2C%22background%22%3A%22%22%2C%22font_size%22%3A%22%22%7D";

    public static void main(String[] args) throws IOException, SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JdbcSimpleUtils<DataNovel> db = JdbcSimpleUtils.instance("jdbc:sqlite:D:/code/basic-java/backup/index.db", DataNovel.class);
        List<DataNovel> exist = db.list();
        List<DataNovel> infos = create();
        db.insertOrUpdate(infos);
    }

    public static List<DataNovel> create() throws IOException {
        List<DataNovel> res = new ArrayList<>();
        Map<String, String> oldNameMap = new HashMap<>();

        String folder = "D:/code/basic-java/backup/novel/";
        // 加载收藏内容
        File fav = new File(folder + "index.html");
        Element doc = null;
        if (fav.exists()) {
            doc = Jsoup.parse(fav, "utf-8", "").getElementById("fav_author_table");
        } else {
            Document html = getHtml("https://my.jjwxc.net/backend/favoriteauthor.php");
            if (fav.createNewFile()) {
                doc = html.getElementById("fav_author_table");
                if (doc == null) {
                    return res;
                }
                write(fav, doc.outerHtml());
            }
        }
        if (doc == null) {
            return res;
        }

        // 处理文章数据
        for (Element child : doc.getElementsByTag("tbody").get(0).getElementsByTag("tr")) {
            Element item = child.children().get(1);
            String authorName = item.text().trim();
            String authorHref = item.child(0).attributes().get("href");
            String authorId = authorHref.split("authorid=")[1];

            try {
                String folderPath = "Y:/" + authorName;
                if (new File(folderPath).mkdir()) {
                    System.out.println(folderPath + "  >>>>  已创建");
                }

                File authorFile = new File(folder + "/" + authorId + ".html");
                Element list = null;
                if (authorFile.exists()) {
                    list = Jsoup.parse(authorFile, "utf-8", "");
                }
                if (list == null || list.getElementsByTag("body").get(0).children().isEmpty()) {
                    Document authorDoc = getHtml("https://www.jjwxc.net/oneauthor.php?authorid=" + authorId);
                    if (authorFile.createNewFile()) {
                        System.out.println(">>>>> 文件已存在");
                    }
                    Elements tmp = authorDoc.getElementsByTag("table");
                    if (tmp.isEmpty()) {
                        continue;
                    } else {
                        list = tmp.get(7);
                    }
                    write(authorFile, list.outerHtml());
                }

                for (Element element : list.getElementsByTag("tr")) {

                    Elements title = element.getElementsByTag("a");
                    if (title.isEmpty()) {
                        continue;
                    }
                    String novelHref = title.get(0).attributes().get("href");
                    if (novelHref == null || novelHref.length() == 0) {
                        continue;
                    }
                    // 列出作者名称
                    String novelName = authorName + " " + title.get(0).text().trim().replaceAll("/", "&");
                    String novelId = novelHref.split("novelid=")[1];

                    try {
                        String novelPath = folderPath + "/" + novelName + ".txt";
                        DataNovel infoItem = new DataNovel();
                        infoItem.setId(novelId);
                        infoItem.setName(novelName);
                        infoItem.setPath(novelPath);
                        infoItem.setAuthorId(authorId);
                        infoItem.setAuthorName(authorName);
                        infoItem.setStatus("404");

                        res.add(infoItem);
                        // 锁定的文件直接跳过了吧
                        if (novelName.contains("[锁]")) {
                            System.out.println(novelName + "   >>>>>>   锁定暂不处理");
                            infoItem.setStatus("lock");
                            continue;
                        }

                        String oldName = oldNameMap.get(novelId);

                        File novelFile = new File(novelPath);
                        File novelFileBk = new File(novelPath + ".bk");
                        if (oldName != null && oldName.length() > 0 && !oldName.equals(novelName)) {
                            // 如果旧文件名存在且不等于新文件名; 直接重命名旧文件
                            String novelOldPath = folderPath + "/" + oldName + ".txt";
                            File oldFile = new File(novelOldPath);
                            File oldFileBk = new File(novelOldPath + ".bk");
                            if (oldFile.exists()) {
                                if (oldFile.renameTo(novelFile)) {
                                    System.out.println(novelOldPath + "  >>>>  重命名");
                                }
                                oldFileBk.deleteOnExit();
                                infoItem.setStatus("exists");
                            }
                            if (oldFileBk.exists()) {
                                if (oldFileBk.renameTo(novelFileBk)) {
                                    System.out.println(novelOldPath + ".bk  >>>>  重命名");
                                }
                            }
                        } else {
                            // 当作新文件处理，检查文件是否存在
                            if (!novelFile.exists()) {
                                System.out.println(novelPath + "  >>>>  遍历");
                                if (novelFileBk.createNewFile()) {
                                    write(novelFileBk, "todo");
                                }
                            } else {
                                novelFileBk.deleteOnExit();
                                infoItem.setStatus("exists");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(novelName + "  >>>>  失败");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(authorName + "  >>>>  失败");
            }
        }
        return res;
    }

    public static void write(File file, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.close();
    }

    public static Document getHtml(String url) throws IOException {
        return Jsoup.connect(url).header("Cookie", COOKIE).execute().parse();
    }
}
