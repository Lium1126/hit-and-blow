/**
 * 回答1回に対する試行の結果を保持するクラスです.
 * @version 1.0
 */

package jp.ac.ait.k19061;

public class Response {

    /*---フィールド---*/
    /**
     * 1回の試行でのヒット数
     */
    private int hit;     // 外部からの変更は受け付けないためprivate

    /**
     * 1回の試行でのブロー数
     */
    private int blow;    // 外部からの変更は受け付けないためprivate

    /*---コンストラクタ---*/
    /**
     * ヒット数とブロー数を指定して初期化する.
     * @param hit 初期化時に設定するヒット数
     * @param blow 初期化時に設定するブロー数
     */
    public Response(int hit, int blow) {
        setHit(hit);
        setBlow(blow);
    }

    /**
     * ヒット数とブロー数はともに0で初期化する.
     */
    public Response() {
        this(0, 0);
    }

    /*---メソッド---*/
    /**
     * ヒット数のゲッター.
     * @return ヒット数
     */
    public int getHit() {
        return hit;
    }

    /**
     * ヒット数のセッター.
     * @param hit 設定するヒット数
     */
    public void setHit(int hit) { this.hit = hit; }


    /**
     * ブロー数のゲッター.
     * @return ブロー数
     */
    public int getBlow() {
        return blow;
    }

    /**
     * ブロー数のセッター
     * @param blow 設定するブロー数
     */
    public void setBlow(int blow) {
        this.blow = blow;
    }
}
