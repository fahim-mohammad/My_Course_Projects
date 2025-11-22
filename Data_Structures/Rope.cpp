#include <bits/stdc++.h>
using namespace std;
struct Node{ char c; int pr,sz; Node *l,*r; Node(char ch):c(ch),pr((rand()<<16)^rand()),sz(1),l(nullptr),r(nullptr){} };
int sz(Node* t){ return t? t->sz:0; }
void upd(Node* t){ if(t) t->sz = 1 + sz(t->l) + sz(t->r); }
Node* merge(Node* a, Node* b){
    if(!a) return b;
    if(!b) return a;
    if(a->pr > b->pr){
        a->r = merge(a->r,b);
        upd(a);
        return a;
    } else {
        b->l = merge(a,b->l);
        upd(b);
        return b;
    }
}
void split(Node* t, int k, Node*& a, Node*& b){
    if(!t){ a=b=nullptr; return; }
    if(sz(t->l) >= k){
        split(t->l,k,a,t->l);
        b=t;
        upd(b);
    } else {
        split(t->r,k - sz(t->l) - 1, t->r, b);
        a=t;
        upd(a);
    }
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    srand(71234);
    string s; if(!(cin>>s)) return 0;
    int q; cin>>q;
    Node* root=nullptr;
    for(char ch: s) root = merge(root, new Node(ch));
    while(q--){
        int i,j,k; cin>>i>>j>>k;
        Node *a,*b,*c,*mid;
        split(root,i,a,b);
        split(b,j-i+1,mid,c);
        root = merge(a,c);
        split(root,k,a,b);
        root = merge(merge(a,mid),b);
    }
    string out; out.reserve(sz(root));
    function<void(Node*)> dfs = [&](Node* t){
        if(!t) return;
        dfs(t->l);
        out.push_back(t->c);
        dfs(t->r);
    };
    dfs(root);
    cout<<out<<"\n";
    return 0;
}
