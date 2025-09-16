import { useState } from "react";
import InputComponent from "../examples/InputComponent";
function Trial() {
    const [isExample, setIsExample] = useState(false);
    return (<>
        <main>
            <div className="container">
                <InputComponent></InputComponent>
            </div>
        </main>
    </>)
}

export default Trial