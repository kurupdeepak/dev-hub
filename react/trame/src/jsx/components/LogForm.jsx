import { useState, useRef } from "react"
function LogForm({ onSubmit }) {
    const [logForm, setForm] = useState({
        dateInput: new Date().toISOString().split("T")[0],
        contentInput: ""
    });

    const dateRef = useRef()
    const categoryRef = useRef()
    const subCategoryRef = useRef()
    const contentRef = useRef()
    const handleSubmit = () => {
        // const name = nameRef.current.value;
        // if (!name.trim()) {
        //     alert("Name is required");
        //     return;
        // }
        // // proceed to submit
    };
    function populateState() {
        const topEntry = {
            day: dateRef.current.value,
            category: categoryRef.current.value,
            subCategory: subCategoryRef.current.value,
            content: contentRef.current.value
        };
        onSubmit(topEntry)
    }
    return (
        <>
            <h1>Log an Entry</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor="datetime">Date</label>
                <input type="date" id="dayControl" defaultValue={logForm.dateInput} ref={dateRef} />
                {/* <label htmlFor="category">Category</label>
                <select id="category" ref={categoryRef}>
                    <option>Thoughts</option>
                    <option>Actions</option>
                    <option>Questions</option>
                    <option>Observations</option>
                    <option>Ideas</option>
                    <option>Follow-Up</option>
                    <option>Discoveries</option>
                    <option>References</option>
                </select> */}
                <fieldset style={{ fontSize: "14px", marginBottom: "10px" }}>
                    <legend>Category</legend>
                    <div
                        ref={categoryRef}
                        style={{ display: "flex", gap: "1rem", flexWrap: "wrap", fontSize: "14px" }}
                    >
                        <label>
                            <input type="radio" name="category" value="Thoughts" defaultChecked /> Thoughts
                        </label>
                        <label>
                            <input type="radio" name="category" value="Actions" /> Actions
                        </label>
                        <label>
                            <input type="radio" name="category" value="Questions" /> Questions
                        </label>
                        <label>
                            <input type="radio" name="category" value="Observations" /> Observations
                        </label>
                        <label>
                            <input type="radio" name="category" value="Ideas" /> Ideas
                        </label>
                        <label>
                            <input type="radio" name="category" value="Follow-Up" /> Follow-Up
                        </label>
                        <label>
                            <input type="radio" name="category" value="Discoveries" /> Discoveries
                        </label>
                        <label>
                            <input type="radio" name="category" value="References" /> References
                        </label>
                    </div>
                </fieldset>
                {/*<label htmlFor="subcategory">Sub-Category</label>
                 <select id="subcategory" ref={subCategoryRef}>
                    <option>Food</option>
                    <option>Physical Activity</option>
                    <option>Glucose Reading</option>
                    <option>General</option>
                    <option>Not Sure</option>
                    <option>TV</option>
                </select> */}
                <fieldset style={{ fontSize: "14px", marginBottom: "10px" }}>
                    <legend>Sub-Category</legend>
                    <div ref={subCategoryRef} style={{ display: "flex", gap: "1rem", flexWrap: "wrap", fontSize: "14px" }}>
                        <label>
                            <input type="radio" name="subcategory" value="Food" defaultChecked /> Food
                        </label>
                        <label>
                            <input type="radio" name="subcategory" value="Physical Activity" /> Physical Activity
                        </label>
                        <label>
                            <input type="radio" name="subcategory" value="Glucose Reading" /> Glucose Reading
                        </label>
                        <label>
                            <input type="radio" name="subcategory" value="General" /> General
                        </label>
                        <label>
                            <input type="radio" name="subcategory" value="Not Sure" /> Not Sure
                        </label>
                        <label>
                            <input type="radio" name="subcategory" value="TV" /> TV
                        </label>
                    </div>
                </fieldset>
                <label htmlFor="content">Description</label>
                <textarea id="content" ref={contentRef} rows="5" placeholder="Write your note here..."></textarea>
                <button onClick={populateState}>Submit</button>
            </form>
        </>
    )
}
export default LogForm