#include <vector>
#include <iostream>
using std::vector;

class Solution
{
public:
    vector<int> postorder(Node *root)
    {
        vector<int> postOrderedNodes;
        recursiveTraversal(root, postOrderedNodes);
        return postOrderedNodes;
    }

    void recursiveTraversal(Node *current, vector<int> &postOrderedNodes)
    {
        if (current)
        {
            for (Node *child : current->children)
            {
                recursiveTraversal(child, postOrderedNodes);
            }
            postOrderedNodes.push_back(current->val);
        }
    }
};

class Node
{
public:
    int val;
    vector<Node *> children;

    Node() {}

    Node(int _val)
    {
        val = _val;
    }

    Node(int _val, vector<Node *> _children)
    {
        val = _val;
        children = _children;
    }
};