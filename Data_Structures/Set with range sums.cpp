#include <bits/stdc++.h>
using namespace std;
using ll = long long;
struct Node{ ll key,sum; int pr; Node* l; Node* r; Node(ll k):key(k),sum(k),pr((rand()<<16)^rand()),l(nullptr),r(nullptr){} };
ll getsum(Node* t){ return t? t->sum:0; }
void upd(Node* t){ if(t) t->sum = t->key + getsum(t->l) + getsum(t->r); }
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
void split(Node* t, ll key, Node*& a, Node*& b){
    if(!t){ a=b=nullptr; return; }
    if(t->key < key){
        split(t->r,key,t->r,b);
        a=t;
        upd(a);
    } else {
        split(t->l,key,a,t->l);
        b=t;
        upd(b);
    }
}
bool exists(Node*& root, ll x){
    Node *a,*b,*c;
    split(root,x,a,b);
    split(b,x+1,b,c);
    bool res = (b!=nullptr);
    b = merge(b,c);
    root = merge(a,b);
    return res;
}
void insert(Node*& root, ll x){
    Node *a,*b,*c;
    split(root,x,a,b);
    split(b,x+1,b,c);
    if(!b){
        b = new Node(x);
    }
    root = merge(merge(a,b),c);
}
void erase(Node*& root, ll x){
    Node *a,*b,*c;
    split(root,x,a,b);
    split(b,x+1,b,c);
    root = merge(a,c);
}
ll rangesum(Node*& root, ll l, ll r){
    Node *a,*b,*c;
    split(root,l,a,b);
    split(b,r+1,b,c);
    ll res = getsum(b);
    b = merge(b,c);
    root = merge(a,b);
    return res;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    srand(712367);
    int n; if(!(cin>>n)) return 0;
    const ll M = 1000000001LL;
    Node* root=nullptr;
    ll last=0;
    while(n--){
        char t; cin>>t;
        if(t=='+'){
            ll i; cin>>i; ll v = (i + last) % M;
            insert(root,v);
        } else if(t=='-'){
            ll i; cin>>i; ll v = (i + last) % M;
            erase(root,v);
        } else if(t=='?'){
            ll i; cin>>i; ll v = (i + last) % M;
            bool f = exists(root,v);
            cout<<(f?"Found\n":"Not found\n");
        } else if(t=='s'){
            ll l,r; cin>>l>>r;
            ll L = (l + last) % M;
            ll R = (r + last) % M;
            ll ans = rangesum(root,L,R);
            cout<<ans<<"\n";
            last = ans;
        }
    }
    return 0;
}
