#ifndef tree_node
# define tree_node

class Tree_node {
 private:
     int id;
     Tree_node *left;
     Tree_node *right;
     Tree_node *parent;
 public:
     int is_parent;
     Tree_node();
     Tree_node(Tree_node *parent);
     int get_id();
     void set_parent(Tree_node *parent);
     Tree_node* get_parent();
     Tree_node* insert(int id);
     Tree_node* insert(Tree_node *tree);
     Tree_node* get(int id);
     Tree_node* min();
     Tree_node* top();
     Tree_node* next();
     ~Tree_node();
};

#endif
