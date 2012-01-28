void GetPath(int size, int x,int y,vector<char>& vec)
{
if(x==size&&y==size)
{  vector<char>::iterator it;
   for(it=vec.begin();it!=vec.end();++it)   { cout<<*it; }
   cout<<endl;
   return;
}
if(x<size) {
                vec.push_back('R');
                GetPath(size,x+1,y,vec);
                vec.pop_back();
            }
if(y<size) {
                vec.push_back('D');
                GetPath(size,x,y+1,vec);
                vec.pop_back();
            }
return;
}

参照网上的思路，写了一个wildcard match。
做面试用还算简洁。谁给Review一下？

#include <iostream> 
using namespace std;
bool match(char* in, int iidx, char* ptn, int pidx)
{
    if (!in || !ptn)  return false;

    // base case
    if (!in[iidx] && !ptn[pidx]) return true;
    if (!ptn[pidx]) return false;
    if (!in[iidx]) {
        while(ptn[pidx]) if (ptn[pidx++]!='*') return false;
        return true;
    }

    if (ptn[pidx]=='?' ||  ptn[pidx]==in[iidx])
        return match(in, iidx+1, ptn, pidx+1);
    if (ptn[pidx]=='*') {
        while (in[iidx]) {
            if (match(in, iidx++, ptn, pidx+1)) return true;
        }
        while(ptn[++pidx]) if (ptn[pidx]!='*') return false;
        return true;
    }
    return false;
}

int main()
{
        char input[] = "regular expression";
        char pattern[] = "?egu*pr??*o*";        
        cout << input << " => "  << pattern << " : " << 
        match(input, 0, pattern, 0) << endl;
    cout << "ab" << " => " << "a" << " : " << 
        match("ab", 0, "a", 0) << endl;
}