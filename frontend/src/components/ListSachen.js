import {useEffect, useState} from "react";
import {addItem, deleteItem, getShoppingLists, putQuantityMinus, putQuantityPlus} from "../service/apiService";

export default function ListSachen() {
    const [itemList, setItemList] = useState()
    /*  {itemName: "Gurke", itemKey: uuidv4(), itemQuantity: 1},
      {itemName: "Eis", itemKey: uuidv4(), itemQuantity: 2}
    */

    const [itemInput, setItemInput] = useState("")

    /*function AddItemInput() {
        const itemToCheck = itemList.find((item) => item.itemName === itemInput);
        if (itemToCheck !== undefined) {
            alert(itemInput + " ist schon in der Liste!");
            setItemInput("");
            return;
        }
        const newItem = {itemName: itemInput, itemKey: uuidv4(), itemQuantity: 1}
        const newItemList = [...itemList, newItem];
        setItemList(newItemList);
        setItemInput("");
    }*/

   /* function QuantityPlus(itemKey) {
        //console.log(itemKey)
        const newItemList = itemList.map((item) => {
            if (item.itemKey === itemKey) {
                return {...item, itemQuantity: item.itemQuantity + 1}
            } else {
                return item;
            }
        })
        //console.log(newItemList);
        setItemList(newItemList);
    }*/

   /* function QuantityMinus(itemKey) {
        console.log(itemKey)
        const itemToChange = itemList.find((item) => item.itemKey === itemKey);
        if (itemToChange) {
            itemToChange.itemQuantity--;
            if (itemToChange.itemQuantity === 0) {
                const newItemList = itemList.filter((item) => item.itemKey !== itemKey);
                setItemList(newItemList);
            } else {
                setItemList([...itemList]);
            }
        }
    }*/

   /* function ItemRemove(itemKey) {
        console.log("ItemRemove", itemKey);
        const newItemList = itemList.filter((item) => item.itemKey !== itemKey);
        setItemList(newItemList);
    }*/

    useEffect(() => {
        setupItemList().catch(e => console.log(e.message))
        console.log(itemList)
    }, [])
    const setupItemList = () => getShoppingLists().then(setItemList)

    if (!itemList) {
        return (<h1 className="Loading">Loading...</h1>)
    }

    const addAndRefresh = () => {
        addItem({itemName: itemInput, itemQuantity: 1})
            .then(setItemList)
            .catch(err => console.log(err));
    }

    function plusAndRefresh(itemKey) {
        putQuantityPlus(itemKey)
            .then(setItemList)
            .catch(err => console.log(err));
    }

    function deleteAndRefresh(itemKey) {
        deleteItem(itemKey)
            .then(setItemList)
            .catch(err => console.log(err));
    }

    /*function minusAndRefresh(itemKey) {
        putQuantityMinus(itemKey)
            .then(setItemList)
            .catch(err => console.log(err));
    }*/

    const minusAndRefresh = (itemKey) => {
        putQuantityMinus(itemKey)
            .then(setItemList)
            .catch(err => console.log(err));
    }

    return (
        <div className="App">
            <h1>Einkaufslist</h1>
            <h2>hahaha</h2>
            <div className="main-container">
                <div className="add-item-box">
                    <input className="add-item-input"
                           type="text"
                           placeholder="Add an Item:"
                           onChange={(event) => setItemInput(event.target.value)}
                           value={itemInput}
                    />
                    <button className="add-item-button"
                            onClick={() => addAndRefresh()}>Add
                    </button>
                </div>
                <div className="item-list">
                    {itemList.map((item) => (<div key={item.itemKey} className="item-info">
                            <div className="item-name">
                                <span>{item.itemName}</span>
                            </div>
                            <div className="quantity">
                                <button className="plus-button" onClick={() => plusAndRefresh(item.itemKey)}>+</button>
                                <span>{item.itemQuantity}</span>
                                <button className="minus-button" onClick={() => minusAndRefresh(item.itemKey)}>-</button>
                            </div>
                            <div className="item-remove">
                                <button className="remove-button" onClick={() => deleteAndRefresh(item.itemKey)}> remove
                                </button>
                            </div>
                        </div>

                    ))}


                </div>
            </div>
        </div>
    )

}