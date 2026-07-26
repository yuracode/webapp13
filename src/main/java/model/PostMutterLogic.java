package model;

import java.util.List;

public class PostMutterLogic {
    public void execute(Mutter mutter,List<Mutter> mutterList) {
        // ここでMutterオブジェクトをデータベースに保存する処理を実装する
        // 例: データベース接続、INSERT文の実行など
        mutterList.add(0, mutter);
    }
}
