import { useRef } from "react"
function LogForm({ onSubmit }) {
    const dateRef = useRef()
    const categoryRef = useRef()
    const subCategoryRef = useRef()
    const contentRef = useRef()

    function populateState() {
        const entryJSON = {
            day: dateRef.current.value,
            category: categoryRef.current.value,
            subCategory: subCategoryRef.current.value,
            content: contentRef.current.value
        };
        onSubmit(entryJSON)
    }
    return (
        <>
            <h1>Log an Entry</h1>
            <label htmlFor="datetime">Date</label>
            <input type="date" id="dayControl" ref={dateRef} />
            <label htmlFor="category">Category</label>
            <select id="category" ref={categoryRef}>
                <option>Thoughts</option>
                <option>Actions</option>
                <option>Questions</option>
                <option>Observations</option>
                <option>Ideas</option>
                <option>Follow-Up</option>
                <option>Discoveries</option>
                <option>References</option>
            </select>
            <label htmlFor="subcategory">Sub-Category</label>
            <select id="subcategory" ref={subCategoryRef}>
                <option>Food</option>
                <option>Physical Activity</option>
                <option>Glucose Reading</option>
                <option>General</option>
                <option>Not Sure</option>
                <option>TV</option>
            </select>
            <label htmlFor="content">Description</label>
            <textarea id="content" ref={contentRef} rows="5" placeholder="Write your note here..."></textarea>
            <button onClick={populateState}>Submit</button>
        </>
    )
}
export default LogForm