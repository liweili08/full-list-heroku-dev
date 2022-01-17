import "./Header.css"
import AddItem from "./AddItem";

export default function Header(props){
    return(<div className="header">
            <h1>Was möchten Sie einkaufen?</h1>
            <h2>Hier ist Ihre Einkaufliste:</h2>
            <h3> {props.title}</h3>

    </div>
    )
}