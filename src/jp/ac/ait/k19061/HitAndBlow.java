/**
 * ゲームの開始を担当するメインクラスです.
 * @version 1.0
 */

package jp.ac.ait.k19061;

import java.util.Scanner;

public class HitAndBlow {

    /**
     * ゲームを開始する(mainメソッド).
     * ユーザーからの入力を受け付け、それが正解か判定することを繰り返す.
     * 正解した、もしくは不正な入力がされたら終了する.
     */
    public static void main(String[] args) {

        // 1.Managerクラスを変数appにインスタンス化(答えの生成などのゲームの準備が整う)
        Manager app = new Manager();

        // 2.デバッグ時のみ、答えの生成ができているか確認
        // System.out.println(app.getAnswer().get());

        do {
            // 3.ユーザからの入力を受け付ける
            System.out.print("input " + Answer.DIGITS + " numbers :");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            // 4.入力された文字列が、符号なし整数値のみで、かつ文字の長さがAnswer.DIGITSと等しいかをチェックし、
            // 合致しない場合はエラーとしてプログラムを終了
            if (!StringUtilities.isUnsignedInteger(input) || input.length() != Answer.DIGITS) {
                System.out.println("Error: input value is not a number or length mismatch");
                return;
            }
            /*memo:以下は正常な値しか流れてこない*/

            // 5.Managerのインスタンスより、solve(String value)メソッドを呼び、Responseのインスタンスを受け取る
            Response ret = app.solve(input);

            // 6.受け取ったResponseのインスタンスのgetHit()の戻り値が、Answer.DIGITSと等しい場合、
            // 正解のメッセージと、試行回数(Managerのインスタンス.getCount())を出力
            if (ret.getHit() == Answer.DIGITS) {
                System.out.println("Collect!! Challenge count: " + app.getCount());
                return;
            }

            // 7.6の条件に合致しない場合、ResponseのインスタンスのgetHit()とgetBlow()をHit,Blowの値として画面に出力し、
            // 再び入力を受け付ける
            System.out.println("Hit: " + ret.getHit() + ", Blow: " + ret.getBlow());
        } while(true);
    }
}
