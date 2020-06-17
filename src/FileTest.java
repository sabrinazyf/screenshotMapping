import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileTest {
    private static Map<String, String> nameMap = new HashMap<>();

    private static void classification(File file, String outputPath) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            try {
                if (f.isDirectory())
                    classification(f, outputPath);
                if (f.isFile()) {
                    String s = f.toString();
                    s = s.substring(s.length() - 36, s.length() - 4);
                    String ms;
                    if(nameMap.containsKey(s)) ms = nameMap.get(s);
                    else ms = "其他";
                    if (ms.length() > 0) s = ms;
                    (new File(outputPath + s + "\\")).mkdirs();
                    try {
                        copyFile(f.toString(), outputPath + s + "\\" + f.getName());
                        System.out.println("Moving file: " + f.getName() + " to " + s);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private static void makeMap() {
        nameMap.put("0DC6ECE91CF3F6F02BAFC002E3FFBAAD", "火焰纹章风花雪月");
        nameMap.put("1CFA4F0AFF14019A30AD91A509EF4A14", "乐高世界");
        nameMap.put("1E95E5926F1CB99A87326D927F27B47E", "其他");
        nameMap.put("3C66B776DB1AA06323037049FACD96D3", "宝可梦剑");
        nameMap.put("4CBEE39065EC88984BABA68A511DDD19", "异度之刃2黄金国");
        nameMap.put("5E92066D83C981FCBC05AE4D9711906A", "任天堂会员家庭游戏");
        nameMap.put("5F25EBBAB5987964E56ADA5BBDDE9DF2", "宝可梦去吧伊布");
        nameMap.put("8AEDFF741E2D23FBED39474178692DAF", "马里奥奥德赛");
        nameMap.put("50E2A11CE4BDDC72EF99DF78315D4938", "其他");
        nameMap.put("57B4628D2267231D57E0FC1078C0596D", "其他");
        nameMap.put("638E7E1EEC4CD8A239243633C0345A07", "健身环大冒险");
        nameMap.put("931D32AB2EF79DF207B086838CA778CF", "达芬奇之家");
        nameMap.put("16851BE00BC6068871FE49D98876D6C5", "马里奥赛车8");
        nameMap.put("9129043EF2AAD7F1157CF852BACB8F7D", "塞尔达传说梦见岛");
        nameMap.put("A6C056CABE0E1894654A3769FAF6D11E", "奇诺比奥队长");
        nameMap.put("B20FAEC679A3A9320864DC374CFB9713", "星之卡比新星同盟");
        nameMap.put("E4B364C957D95017CA1171810D655865", "方可梦");
        nameMap.put("EC1951C1CF03769053B9622056A16777", "歧路旅人");
        nameMap.put("ECCAE210FD0AA1E799B6F807E179FB9A", "异度之刃2");
        nameMap.put("F1C11A22FAEE3B82F21B330E1B786A39", "塞尔达传说荒野之息");
        nameMap.put("F6DC99542CAAB4B06860324827349DAD", "节奏海拉鲁");
        nameMap.put("02CB906EA538A35643C1E1484C4B947D", "集合吧！动物森友会");
        nameMap.put("74EA5D8C57EB2F39A242F585A490F51B","上古卷轴5：天际");
        nameMap.put("26C50A4CBD5E4BB63D6128EE895B3882","二之国");
    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(srcPath));
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(destPath));

        byte[] readData = new byte[1024];
        int length = 0;
        while ((length = fis.read(readData)) != -1) {
            fos.write(readData, 0, length);
        }

        fos.flush();
    }

    public static void main(String[] args) {
        String path = "G:\\Pictures\\Album\\2020\\05";
//        String path = "G:\\Nintendo\\Album\\2020\\04";
        File file = new File(path);
        makeMap();
        classification(file, "G:\\Pictures\\temp\\");
    }
}


