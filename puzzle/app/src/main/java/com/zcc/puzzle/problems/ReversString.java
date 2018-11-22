package com.zcc.puzzle.problems;

public class ReversString {

    public static final String input = "uxzpsogzkwgwacxxvvzlhkaahjaqagdfjkmyutvhxclzskvxckjvfgzptlzldjwhrpocfugzqkpaxexezbvggtkoxriysqivupofrcoxbrdgccvphvdtvrjtsbospmgyfduvaslnvxwuepleziodaaqmonsxjszyjwjmvgdqgowjjtwdmynvirnlujimedfyntgacntvyqujvehhvruiolfkeprqpzdvmapeukemmzxdtyolxeixatgsupvpidmeyifjyxkzudxvsunghtklzgxsjhrxgxgqcdebukrarpkpqmusempvulagashxpaisfvetrmiqiordsyjgyjmkvavxorrmnxbiikuxmezpkhgkjzmapldnmjvfxtmckskiwhdnuqpqrsrdspxuixxnibjxoyagijmlbhjtuchzbdpaxommfvlbpxfnzkkcdentdhhxracunvrtqxrbqanufaglncjqiwofanuznfmbtjalehlqidtcmqbsgppqyoaoglifareljluigqyxtveukstzepridpmdltpxjmzdvatgzmqexrauywreoslyoydmiyipyqiaihfjqncelefiaxjhdaamrvahbvoznsfvsdknlktsifioxjdsqldzlyzqkqxkwjfrehqbhlaanbcvxomxyypqfxbwmtaiegcjlzeslmpghirzsaprxdcbobflvbupwahxwjgrcqskewvjsjyyggozkvwwytrwpmuguclssmrshlwukkjapiwnkybydergdqkhttbakooghbskiqlesocfrjuxotecnhkfmwtmzcysppmffnskvfabunfzsibqrerfstonzjhtcpnscpteflsnmqqphelpngnlnczritcjxewlhftujrpaeaxylqkswaisvzgciaemvodvcnqtuwcjkmzjzkikaqifymwwlvyxndgwwlauwiyiflgoahyaavkudvemfftzwlxdltwicouwboeaddxmvind";
    public static final int K = 22;


    public static void main (String[] args){
       ReversString rr = new ReversString();
       String out  =rr.reverseStr(input,K);

    }

    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1 || k <= 1) return s;
        int i = 0;
        char[] tt = s.toCharArray();
        for (; i * k  < s.length(); i += 2) {
            doit(i, tt, k);
        }
        doit(i, tt, k);
        return String.valueOf(tt);
    }

    private void doit(int pow, char[] s, int k) {
        int max = (pow + 1) * k;
        if (max > s.length) {
            max = s.length;
        }
        for (int i = pow * k; i < (pow + 1) * k && i < s.length; i++) {
            int j = max + pow * k - i - 1;
            if (j <= i) break;
            else swap(s, i, j);
        }
    }

    private void swap(char[] s, int a, int b) {
        char cc = s[a];
        s[a] = s[b];
        s[b] = cc;
    }
}
