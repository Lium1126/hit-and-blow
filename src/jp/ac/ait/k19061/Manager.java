/**
 * ゲーム全体を管理するクラスです.
 * @version 1.0
 */

package jp.ac.ait.k19061;

public class Manager {

    /*---フィールド---*/
    /**
     * 回答の試行回数をカウント
     */
    private int count;      // 外部からの変更は受け付けないためprivate

    /**
     * ユーザーが当てる解答
     */
    private Answer answer;  // 外部からの変更は受け付けないためprivate

    /*---コンストラクタ---*/
    /**
     * 試行回数を0回にし、解答を生成する.
     */
    public Manager() {
        this.count = 0;              // countに初期値0を代入
        this.answer = new Answer();  // answerにAnswerクラスをインスタンス化して代入
    }

    /*---メソッド---*/
    /**
     * countのゲッター.
     * @return これまでの試行回数
     */
    public int getCount() {
        return count;
    }

    /**
     * answerのゲッター.
     * @return ユーザが当てる解答
     */
    public Answer getAnswer() {
        return answer;
    }

    /*---メソッド---*/
    /**
     * HitAndBlowゲームの回答を1回行う.
     * @param in 回答者の答え
     * @return 試行のヒット数,ブロー数を持ったResponseクラス
     */
    public Response solve(String in) {
        // 1.countに1を足し、試行回数をカウントアップ
        count += 1;

        // 2.Hit, Blowを計算し、Responseのインスタンスで返す
        // ここで、Blowの数に、Hitの数は含まれない点に注意
        Response resp = new Response();    // 返り値用Responseクラス変数
        String ans = answer.get();         // 答えの文字列
        char in_arr[] = in.toCharArray();  // 入力された文字列の配列

        // 2-1.入力された文字列の配列を取得し、1文字ずつチェックする
        for (int i = 0;i < Answer.DIGITS;i++) {
            // 2-2.取り出した文字が答えの中にある場合
            if (ans.indexOf(in_arr[i]) != -1) {
                // 2-2-1.その場所が同じ位置だったらhitに1を加算
                if (ans.indexOf(in_arr[i]) == i) resp.setHit(resp.getHit() + 1);
                // 2-2-2.同じ位置でないならblowに1を加算
                else resp.setBlow(resp.getBlow() + 1);
            }
        }

        return resp;
    }
}
