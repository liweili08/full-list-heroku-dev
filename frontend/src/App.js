import './App.css';
import HomePage from "./pages/HomePage";
import ChangePage from "./pages/ChangePage";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import TestPage from "./pages/TestPage";
import {useEffect, useState} from "react";
import AddItem from "./components/AddItem";
import {v4 as uuidv4} from 'uuid';
import {getShoppingLists} from "./service/apiService";



// function NameForm(props){
//     const [value, setValue] = useState('');
//
//     const handleChange=(event)=>{
//         this.setValue(event.target.value);
//
//     };
//     const handleSubmit = (event) => {
//         alert('A name was submitted: ' + this.value);
//         event.preventDefault();
//     };
//     return (
//         <form onSubmit={handleSubmit}>
//             <label>Name:
//                 <input type="text"
//                        value={value}
//                        onChange={handleChange}
//                 />
//             </label>
//             <input type="submit" value="Submit" />
//         </form>
//     );
// }


function App() {
    const [itemList, setItemList] = useState([
        {itemName: "Gurke", itemKey: uuidv4(), itemQuantity: 1},
        {itemName: "Eis", itemKey: uuidv4(), itemQuantity: 2}
    ])

    const [itemInput, setItemInput] = useState("")

    function AddItemInput() {
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
    }

    function QuantityPlus(itemKey) {
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
    }

    function QuantityMinus(itemKey) {
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
    }

    function ItemRemove(itemKey) {
        console.log("ItemRemove", itemKey);
        const newItemList = itemList.filter((item) => item.itemKey !== itemKey);
        setItemList(newItemList);
    }

/*
   useEffect(() => {
        setupItemList().catch(e => console.log(e.message))
    }, [])
    const setupItemList = () => getShoppingLists().then(data => setItemList(data.results))
*/

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
                    <button className="add-item-button" onClick={() => AddItemInput()}>Add</button>
                </div>
                <div className="item-list">
                    {itemList.map((item) => (<div key={item.itemKey} className="item-info">
                            <div className="item-name">
                                <span>{item.itemName}</span>
                            </div>
                            <div className="quantity">
                                <button className="plus-button" onClick={() => QuantityPlus(item.itemKey)}>+</button>
                                <span>{item.itemQuantity}</span>
                                <button className="minus-button" onClick={() => QuantityMinus(item.itemKey)}>-</button>
                            </div>
                            <div className="item-remove">
                                <button className="remove-button" onClick={() => ItemRemove(item.itemKey)}> remove
                                </button>
                            </div>
                        </div>

                    ))}


                </div>
            </div>


            {/*<NameForm />*/}
            {/*    <BrowserRouter>*/}
            {/*        <Routes>*/}
            {/*          <Route path="/" element={<HomePage/>}/>*/}
            {/*          <Route path="/change" element={<ChangePage/>}/>*/}
            {/*            <Route path="/test" element={<TestPage/>}/>*/}
            {/*        </Routes>*/}
            {/*      </BrowserRouter>*/}
        </div>
    );
}

export default App;