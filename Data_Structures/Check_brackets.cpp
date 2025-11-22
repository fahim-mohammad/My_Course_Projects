#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string s;
    if(!getline(cin,s)) return 0;
    vector<pair<char,int>> st;
    for(int i=0;i<(int)s.size();++i){
        char c=s[i];
        if(c=='('||c=='['||c=='{') st.emplace_back(c,i+1);
        else if(c==')'||c==']'||c=='}'){
            if(st.empty()){
                cout<<i+1<<"\n";
                return 0;
            }
            char top=st.back().first;
            if((c==')'&&top!='(')||(c==']'&&top!='[')||(c=='}'&&top!='{')){
                cout<<i+1<<"\n";
                return 0;
            }
            st.pop_back();
        }
    }
    if(!st.empty()){
        cout<<st.front().second<<"\n";
    } else {
        cout<<"Success\n";
    }
    return 0;
}
