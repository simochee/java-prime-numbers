/**
 * 方針：１〜１００万なので１００万までの整数の素数を計算するようにする
 * 出典：http://qiita.com/lrf141/items/3298ce99a3cb8df549c7
 * ★１〜１００万までの素数の数は78498個あるらしいっす
 */

public class App1
{

    public static void main( String[] args )
    {
        // このクラスのインスタンスを生成
        App1 app = new App1();

        // 素数をカウントする
        int count = app.count(1000000);

        System.out.println("１〜１００万の間に素数は" + count + "個あります。");
    }

    // 素数を判定するメソッド
    private boolean isPrime(int num)
    {
        // 素数かどうか
        boolean result = true;

        for(int i = 2; i < num; i++)
        {
            // iの範囲で割り切れたら素数ではない
            if(num % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    // 素数をカウントするメソッド
    private int count(int num)
    {
        // カウント値を保存する変数を初期化
        int count = 0;

        // このクラスのインスタンスを作成
        App1 app  = new App1();

        // 指定値まで繰り返し
        for(int i = 2; i < num; i++)
        {
            // 素数の判定
            if( app.isPrime(i) )
            {
                count++;
            }
        }

        return count;
        
    }

}