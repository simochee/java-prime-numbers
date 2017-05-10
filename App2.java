/**
 * 方針：拾った順列アルゴリズムとApp1を組み合わせる
 * 出典：https://teratail.com/questions/11179
 * ★：１〜７を一度ずつ使った７桁の変数の中に素数は534個あるらしいっす
 */

import java.util.*;

public class App2
{
    public static void main( String[] args )
    {

        // ０〜６の整数を全て使った順列のリストを生成
        List<List<Integer>> list = getPermutations(6);

        // 正しく処理されたら
        if( list != null )
        {
            // 整数のリストを整数値に変換
            List<Integer> numbers = cnvNumber(list, 1);
            App2 app = new App2();
            int count = 0;

            // 各数値について整数かどうか判定する
            for( Integer number: numbers )
            {
                if( app.isPrime(number) )
                {
                    count++;
                }
            }

            System.out.println("１〜７を一度だけ使った７桁の整数値のうち、素数は" + count + "個です。");
        }
        else
        {
            System.out.println("Error: 配列生成メソッドの引数が不正です （ getPermutations( n ) ）");
        }

    }

    // 素数を判定するメソッド from App1
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

    // 配列を数値に変換
    private static List<Integer> cnvNumber( List<List<Integer>> list, Integer offset )
    {
        // 結果を格納するリスト
        List<Integer> results = new ArrayList<Integer>();

        for( List<Integer> item: list )
        {
            // リストを文字列に変換
            String str = "";
            for( Integer num: item )
            {
                str += (num + offset);
            }
            // 文字列を整数値に変換しつつ結果のリストに追加
            results.add( Integer.parseInt(str) );
        }

        return results;
    }

    // １〜引数の順列リストを生成するメソッド
    private static List<List<Integer>> getPermutations( Integer n )
    {

        // nが不正であれば null を返して終了する
        if( n == null || n < 0 )
        {
            return null;
        }

        // 返却用のリストを作成
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // n == 0の場合、長さ0のリストを返却
        if( n == 0 )
        {
            results.add(new ArrayList<Integer>(Arrays.asList(0)));
            return results;
        }

        // n > 0の場合、まず(n - 1)に対する解のリストを再帰で取得
        List<List<Integer>> prevResults = getPermutations(n - 1);

        // (n - 1)のときのリストをループし、要素の順列に n を加えた順列を作成
        for(List<Integer> permutation: prevResults)
        {
            // n を加える位置についてのループ
            for(int i = 0; i <= n; i++) {
                permutation.add(i, n);
                results.add(new ArrayList<Integer>(permutation));
                permutation.remove(n);
            }
            // 全要素を削除
            permutation.clear();
        }
        // 全要素を削除
        prevResults.clear();

        return results;
    }
    
}