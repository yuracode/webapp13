package model;

import java.util.List;

import dao.MutterDAO;

public class PostMutterLogic {
    public void execute(Mutter mutter) {
        // ここでMutterオブジェクトをデータベースに保存する処理を実装する
        // 例: データベース接続、INSERT文の実行など
        MutterDAO mutterDAO = new MutterDAO();
        mutterDAO.create(mutter);
    }
}
