import Header from "../components/Header";
import Navi from "../components/Navi";
//import AddItem from "../components/AddItem";

export default function HomePage(){
    return(
        <div className="homePage">
            <Header title="Probier mal"/>
            {/*<AddItem/>*/}
            <Navi/>
        </div>
    )
}