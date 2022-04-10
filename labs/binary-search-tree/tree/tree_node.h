#ifndef tree_node
# define tree_node

class Tree_node {
 private:
     int id;
     Tree_node *left;
     Tree_node *right;
     Tree_node *parent;
 public:
     Tree_node();
     Tree_node(Tree_node *parent);
     int get_id();
     Tree_node* get_parent();
     Tree_node* insert(int id);
     Tree_node* get(int id);
     Tree_node* min();
     Tree_node* next();
     ~Tree_node();
};

#endif
