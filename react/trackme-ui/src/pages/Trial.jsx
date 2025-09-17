import { useState } from "react";
// import InputComponent from "../examples/InputComponent";
function Trial() {
    const [isExample, setIsExample] = useState(false);
    return (<>
        <main>
            <div className="container">
                {/* <InputComponent></InputComponent> */}
                <h2>Trial Page</h2>
            </div>
        </main>
    </>)
}

export default Trial