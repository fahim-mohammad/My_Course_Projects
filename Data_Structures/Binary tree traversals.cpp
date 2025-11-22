#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if(!(cin>>n)) return 0;
    vector<long long> key(n);
    vector<int> leftt(n), rightt(n);
    for(int i=0;i<n;i++) cin>>key[i]>>leftt[i]>>rightt[i];
    vector<long long> inorder, preorder, postorder;
    if(n>0){
        int root=0;
        {
            stack<int> st;
            int v=root;
            while(v!=-1 || !st.empty()){
                while(v!=-1){ st.push(v); v=leftt[v]; }
                v=st.top(); st.pop();
                inorder.push_back(key[v]);
                v=rightt[v];
            }
        }
        {
            stack<int> st;
            st.push(0);
            while(!st.empty()){
                int v=st.top(); st.pop();
                preorder.push_back(key[v]);
                if(rightt[v]!=-1) st.push(rightt[v]);
                if(leftt[v]!=-1) st.push(leftt[v]);
            }
        }
        {
            stack<int> st;
            int v=root;
            int last=-1;
            while(v!=-1 || !st.empty()){
                while(v!=-1){ st.push(v); v=leftt[v]; }
                int peek=st.top();
                if(rightt[peek]!=-1 && last!=rightt[peek]){
                    v=rightt[peek];
                } else {
                    postorder.push_back(key[peek]);
                    last=peek;
                    st.pop();
                }
            }
        }
    }
    for(size_t i=0;i<inorder.size();i++){ if(i) cout<<' '; cout<<inorder[i]; } cout<<"\n";
    for(size_t i=0;i<preorder.size();i++){ if(i) cout<<' '; cout<<preorder[i]; } cout<<"\n";
    for(size_t i=0;i<postorder.size();i++){ if(i) cout<<' '; cout<<postorder[i]; } cout<<"\n";
    return 0;
}
