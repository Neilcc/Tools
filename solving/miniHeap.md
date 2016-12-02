#### js 的小堆， 没有做过单元测试,  
#### the mini heap which is writen by javascript. not fully tested, just to review and relearn this datastruct.Without the function that construct from an array. Can only add elements and remove elements right now. The key theory is that the heap is sorted and complete binary tree. thus when you add a element to the last, you should adjust heap bottom up. when you delete a element, you should swap it with the last element and adjust it up to bottom. 

#### how to gennerate from a array? That has the same operation with insert.
 1)初始化堆：将R[1..n]构造为堆；
     2)将当前无序区的堆顶元素R[1]同该区间的最后一个记录交换，然后将新的无序区调整为新的堆。
```
const heapNode =require('./heapNode.js');

var map = new Map();
var heapNode = [0];

function find(key) {
    if (typeof key == 'undefined') {
        return undefined;
    }
    return findKey(key, 0, heapNode.length);
}

function getAll() {
    return heapNode;
}

function remove(key) {
    var node = findKey(key);
    if (typeof node != 'undefined') {
        var index = node.index;
        heapNode[index] = heapNode[heapNode.length - 1];
        heapNode.pop();
        adjustDown(index);
    }
}

function adjustDown(index) {
    if (index == 0) {
        return;
    }
    if (index * 2 < heapNode.length) {
        return;
    }
    if (index * 2 + 1 < heapNode.length) {
        if (heapNode[index * 2].value < heapNode[index * 2 + 1].value) {
            var min = heapNode[index * 2].value;
            if (heapNode[index].value > heapNode[index * 2 + 1].value) {
                swap(heapNode, index, index * 2 + 1);
                adjustDown(index * 2 + 1);
            } else if (heapNode[index].value < min) {
                swap(heapNode, index, index * 2);
                adjustDown(index * 2);
            }
        } else {
            var min = heapNode[index * 2 + 1].value;
            if (heapNode[index].value > heapNode[index * 2].value) {
                swap(heapNode, index, index * 2);
                adjustDown(index * 2);
            } else if (heapNode > min) {
                swap(heapNode, index, index * 2 + 1);
                adjustDown(index * 2 + 1);
            }
        }
    } else {
        if (heapNode[index].value > heapNode[index * 2].value) {
            swap(heapNode, index, index * 2);
            adjustDown(index * 2);
        }
    }
}

function swap(array, first, second) {
    var temp = array[first];
    array[first] = array[second];
    array[second] = temp;
}

function adjustUp(index) {
    if (index <= 1) {
        return;
    }
    var parent = index / 2;
    if (heapNode[index].value < heapNode[parent].value) {
        swap(heapNode, index, parent);
        adjustUp(parent);
        return;
    }
}

function add(node) {
    if (typeof Node != 'HeapNode') {
        return undefined;
    }
    node.index = heapNode.length;
    heapNode.push(node);
    adjustUp(heapNode.length - 1);
}

function init() {
    if (heapNode.length == 0) {
        heapNode.push(0);
    }
}

function findKey(key, start, end) {
    if (start >= end) {
        return undefined;
    }
    if (key < heapNode[start].value) {
        return undefined;
    }
    if (key == heapNode[start].value) {
        return key;
    }
    var result = undefined;
    if (start * 2 < end && key > heapNode[start * 2].value) {
        result = findKey(key, start * 2 + 1, end);
    }
    if (typeof result == 'undefined' && start * 2 + 1 < end && key > heapNode[start * 2 + 1].value) {
        result = findKey(key, start * 2 + 1, end);
    }
    return result;
}

module.exports.add = add;
module.exports.remove = remove;
module.exports.find = find;
module.exports.init = init;
module.exports.getAll = getAll;
```
