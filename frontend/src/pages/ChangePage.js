import Navi from "../components/Navi";
import Header from "../components/Header";

export default function ChangePage(){
    return(
        <div className="changePage">
            <Header/>
            <h2>Änderung der Liste</h2>
            <Navi/>
        </div>
    )
}