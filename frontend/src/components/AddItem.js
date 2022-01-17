import {useState} from "react";
import "./AddItem.css"

export default function AddItem() {
    const [shoppingList, setShoppingList] = useState(["Gurke"]);
    const [newShoppingItem, setNewShoppingItem] = useState("");

    function addShoppingItem() {
        // console.log(newShoppingItem)
        if(shoppingList.includes(newShoppingItem)===false) {
            setShoppingList([...shoppingList, newShoppingItem]);

        }else{
            alert( newShoppingItem + " ist schon in der Liste!");
            }
        setNewShoppingItem("");
        }


    return (
        <div className="addItem">
            <ul>{shoppingList.map((shoppingItem,index) =>(
                <li key={index}>{shoppingItem}
                    <button >+</button>
                    {/*<input type="number" />*/}
                    <button>-</button>
                    <button>Remove</button>
                </li>
            ) )}</ul>
            <input type="text" onChange={event => setNewShoppingItem(event.target.value)} value={newShoppingItem}/>
            <button onClick={addShoppingItem}> Add</button>
            {/*<br/>*/}
            {/*<button onClick={removeShoppingItem}> Remove</button>*/}
        </div>
    )
}