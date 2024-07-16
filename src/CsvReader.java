import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CsvReader {

    public static void main(String[] args) {
        // ファイルのパスを指定
        String filePath = "C:\\Users\\y-morioka\\Documents\\FI_JRK_0004_20240603113000.csv";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), Charset.forName("Shift_JIS")))) {
            String line;
            // 1行目のヘッダはスキップ
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t"); // タブ区切りの場合は "\t" を使用

                // 読み込んだCSVファイルの内容を出力
                if (data.length > 0) {
                    for (String field : data) {
                        System.out.print(field + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("不正なデータ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("ファイル読み込みに失敗しました: " + e.getMessage());
        }
    }
}
