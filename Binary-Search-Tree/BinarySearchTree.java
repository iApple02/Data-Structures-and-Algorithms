import java.util.*;
import java.io.*;

public class BinarySearchTree implements Serializable
{
    private TreeNode root;

    private class TreeNode implements Serializable
    {
        private String key;
        private Object value;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode()
        {
            key = "";
            value = null;
            leftChild = null;
            rightChild = null;
        }

        public TreeNode(String inKey, Object inValue)
        {
            if(inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            key = inKey;
            value = inValue;
            leftChild = null;
            rightChild = null;
        }

        //Accessors
        public String getKey()
        {
            return key;
        }

        public Object getValue()
        {
            return value;
        }

        public TreeNode getLeft()
        {
            return leftChild;
        }

        public TreeNode getRight()
        {
            return rightChild;
        }

        public void setLeft(TreeNode newLeft) //Null is a valid child - indicates 'no child'
        {
            leftChild = newLeft;
        }

        public void setRight(TreeNode newRight) //Null is a valid child - indicates 'no child'
        {
            rightChild = newRight;
        }
    }

    public BinarySearchTree()
    {
        root = null;
    }

    public Object find(String key)
    {
        return findRec(key, root);
    }

    private Object findRec(String key, TreeNode currNode)
    {
        Object value = null;

        if(currNode == null) //Best case: not found
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }
        else if(key.equals(currNode.getKey())) //Best case: found
        {
            value = currNode.getValue();
        }
        else if (key.compareTo(currNode.getKey()) < 0) //Go left (recursive)
        {
            value = findRec(key, currNode.getLeft());
        }
        else
        {
            value = findRec(key, currNode.getRight()); //Go right (recursive)
        }
        return value;
    }

    public void insert(String key, Object data)
    {
        if(data == null)
        {
            throw new NoSuchElementException("Inserted data is null");
        }
        else if(root == null)
        {
            root = new TreeNode(key, data);
        }
        else
        {
            insertRec(key, data, root);
        }
    }

    private TreeNode insertRec(String key, Object data, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if(currNode == null) //Best case - found
        {
            currNode = new TreeNode(key, data); //Insertion point
            updateNode = currNode;
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insertRec(key, data, updateNode.getLeft())); //Recursive Left
        }
        else
        {
            currNode.setRight(insertRec(key, data, updateNode.getRight())); //Recursive Right
        }
        return updateNode;
    }

    public void delete(String key)
    {
        if(key.equals(root.getKey()))
        {
            if(root.getLeft() == null && root.getRight() == null)
            {
                root = null;
            }
            else if(root.getLeft() != null && root.getRight() == null)
            {
                root = root.getLeft();
            }
            else if(root.getLeft() == null && root.getRight() != null)
            {
                root = root.getRight();
            }
            else
            {
                TreeNode updateNode = promoteSuccessor(root.getRight());
                if(updateNode != root.getRight())
                {
                    updateNode.setRight(root.getRight());
                }
                updateNode.setLeft(root.getLeft());
                root = updateNode;
            }
        }
        else
        {
            deleteRec(key, root);
        }
    }

    public TreeNode deleteNode(String key, TreeNode delNode)
    {
        TreeNode updateNode = null;
        //When node has no child (Best Case)
        if(delNode.getLeft() == null && delNode.getRight() == null)
        {
            delNode = null;
        }
        //When node has a left child
        else if(delNode.getLeft() != null && delNode.getRight() == null)
        {
            delNode = delNode.getLeft();
        }
        //When node has right child
        else if(delNode.getLeft() == null && delNode.getRight() != null)
        {
            delNode = delNode.getRight();
        }
        //When Node has both left and right child
        else
        {
            updateNode = promoteSuccessor(delNode.getRight());
            if(updateNode != delNode.getRight()) //No Cycles
            {
                updateNode.setRight(delNode.getRight()); //Update Right
            }
            updateNode.setLeft(delNode.getLeft()); //Update Left
            delNode = updateNode;
        }
        return updateNode;
    }

    public TreeNode deleteRec(String key, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if(currNode == null)
        {
            throw new IllegalArgumentException("Key is null");
        }
        else if(key.equals(currNode.getKey()))
        {
            updateNode = deleteNode(key, currNode.getLeft());
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(deleteRec(key, currNode.getRight()));
        } 
        return updateNode;
    }

    private TreeNode promoteSuccessor(TreeNode currNode)
    {
        TreeNode successor = currNode;
        if(currNode.getLeft() != null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            //The successor will be the left most child of the right subtree
            if(successor == currNode.getLeft()) //Parent of successor
            {
                currNode.setLeft(successor.getRight()); //Adopts the right child.
            }
        }
        return successor;
    }

    public String min()
    {
        String minKey;
        if(root == null)
        {
            throw new NoSuchElementException("Tree is empty");
        }
        else
        {
            minKey = minRec(root);
        }
        return minKey;
    }
    
    private String minRec(TreeNode currNode)
    {
        String minKey;
        if(currNode.getLeft() != null) //Not base case
        {
            minKey = minRec(currNode.getLeft()); //Recursive call
        }
        else
        {
            minKey = currNode.getKey();
        }
        return minKey;
    }

    public String max()
    {
        String maxKey;
        if(root == null)
        {
            throw new NoSuchElementException("Tree is empty");
        }
        else
        {
            maxKey = maxRec(root);
        }
        return maxKey;
    }

    private String maxRec(TreeNode currNode)
    {
        String maxKey;
        if(currNode.getRight() != null)
        {
            maxKey = maxRec(currNode.getRight());
        }
        else
        {
            maxKey = currNode.getKey();
        }
        return maxKey;
    }

    public int height()
    {
        return heightRec(root);
    }

    public int heightRec(TreeNode currNode)
    {
        int htSoFar, iLeftHt, iRightHt;

        if(currNode == null)
        {
            htSoFar = -1; //Base case - no more along this branch
        }
        else
        {
            iLeftHt = heightRec(currNode.getLeft()); //Calc left height from here
            iRightHt = heightRec(currNode.getRight()); //Calc Right height from here

            //Get highest of left vs right branches
            if(iLeftHt > iRightHt)
            {
                htSoFar = iLeftHt + 1;
            }
            else
            {
                htSoFar = iRightHt + 1;
            }
        }
        return htSoFar;
    }

    //Using DSALinkedList & DSAQueue from Practical 4
    public DSAQueue inOrder()
    {
        DSAQueue inOrder = new Queue();
        if(root == null)
        {
            throw new NoSuchElementException("Root is null in BST");
        }
        else
        {
            inOrder = inOrderRec(root, inOrder);
        }
        return inOrder;
    }

    public DSAQueue inOrderRec(TreeNode currNode, DSAQueue inOrder)
    {
        if(currNode != null)
        {
            //If left child doesnt exist, go back to previous node.
            inOrderRec(currNode.getLeft(), inOrder); //Go to left child
            
            //Add node to queue.
            inOrder.enQueue(currNode.getKey()); //Visit Node, get Key
            
            inOrderRec(currNode.getRight(), inOrder); //Go to right child
            //Repeat until currNode == null.
        }
        return inOrder;
    }

    public DSAQueue preOrder()
    {
        DSAQueue preOrder = new Queue();
        if(root == null)
        {
            throw new NoSuchElementException("Root is null");
        }
        else
        {
            preOrder = preOrderRec(root, preOrder);
        }
        return preOrder;
    }

    public DSAQueue preOrderRec(TreeNode currNode, DSAQueue preOrder)
    {
        if(currNode != null)
        {
            preOrder.enQueue(currNode.getKey());
            preOrderRec(currNode.getLeft(), preOrder);
            preOrderRec(currNode.getRight(), preOrder);
        }
        return preOrder;
    }

    public DSAQueue postOrder()
    {
        DSAQueue postOrder = new Queue();
        if(root == null)
        {
            throw new NoSuchElementException("Root is null");
        }
        else
        {
            postOrder = postOrderRec(root, postOrder);
        }
        return postOrder;
    }

    public DSAQueue postOrderRec(TreeNode currNode, DSAQueue postOrder)
    {
        if(currNode != null)
        {
            postOrderRec(currNode.getLeft(), postOrder);
            postOrderRec(currNode.getRight(), postOrder);
            postOrder.enQueue(currNode.getKey());
        }
        return postOrder;
    }

    //Read csv file.
    public void readFile(String file, BinarySearchTree BST)
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);
            line = bufRdr.readLine();
            while(line != null)
            {
                processLine(line, BST);
                line = bufRdr.readLine();
            }
            fileStrm.close();
        }
        catch(IOException e)
        {
            System.out.println("Failed to read file" + e.getMessage());
        }
    }

    //Split line using ","
    private void processLine(String line, BinarySearchTree BST)
    {
        String token[] = line.split(",");
        BST.insert(token[0], token[1]);
    }

    //Serializable save
    public void save(String file)
    {
        saveBST(this, file);
    }

    private void saveBST(BinarySearchTree BST, String file)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;
        try
        {
            fileStrm = new FileOutputStream(file);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(BST);
            objStrm.close();
        }
        catch(IOException e)
        {
            System.out.println("Failed to seralize BST");
        }
    }

    //Serializable load
    public BinarySearchTree load(String file)
    {
        return loadBST(file);
    }

    private BinarySearchTree loadBST(String file) 
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        BinarySearchTree BST = null;
        try
        {
            fileStrm = new FileInputStream(file);
            objStrm = new ObjectInputStream(fileStrm);
            BST = (BinarySearchTree)objStrm.readObject();
            objStrm.close();
        }
        catch(ClassNotFoundException e)
        {
            e.getMessage();
        }
        catch(IOException e)
        {
            System.out.println("Failed to load" + e.getMessage());
        }
        return BST;
    }

    public void toCSV(String file, DSAQueue order)
    {
        FileOutputStream saveFile = null;
        PrintWriter write;
        try
        {
            saveFile = new FileOutputStream(file);
            write = new PrintWriter(file);
            while(!order.isEmpty())
            {
                write.println(order.deQueue());
            }
            write.close();
        }
        catch(IOException e)
        {
            System.out.println("Failed to save CSV file from BinarySearchTree");
        }
    }

    
}