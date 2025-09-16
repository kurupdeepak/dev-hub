import { useState, useRef } from "react"
import './styles/LogForm.css'
import { createEntry } from '../../services/entryService';

function LogForm({ onSubmit: setEntryState }) {
    const [errors, setErrors] = useState({});
    const [logForm, setForm] = useState({
        dateInput: new Date().toISOString().split("T")[0],
        contentInput: ""
    });

    const dateRef = useRef()
    const categoryRef = useRef()
    const subCategoryRef = useRef()
    const contentRef = useRef()

    const validate = () => {
        const newErrors = {};
        if (!contentRef.current.value.trim()) newErrors.content = "Description required";
        return newErrors;
    };

    const handleChange = (e) => {
        setForm({ ...logForm, [e.target.name]: e.target.value });
    };
    function getRadioValue(name, refObject) {
        const selectedRadioGroup = refObject.current.querySelectorAll("input[name='" + name + "']");
        let value = ""
        for (let radio of selectedRadioGroup) {
            if (radio.checked) {
                value = radio.value;
                break;
            }
        }
        return value;
    }
    const postEntry = async (topEntry) => {
        // POST to backend
        try {
            const saved = await createEntry(topEntry);
            console.log("Saved entry:", saved);
        } catch (err) {
            console.error("Error:", err);
        }
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const newErrors = validate();
        setErrors(newErrors);
        let selectedSubCategory = getRadioValue('subcategory', subCategoryRef);
        let selectedCategory = getRadioValue('category', categoryRef);
        if (Object.keys(newErrors).length != 0) {
            return;
        }

        console.log("Form submitted: " + JSON.stringify(logForm));

        const topEntry = {
            day: dateRef.current.value,
            category: selectedCategory,
            subCategory: selectedSubCategory,
            content: contentRef.current.value
        };
        setEntryState(topEntry)
        postEntry(topEntry)
    };
    return (
        <>
            <form onSubmit={handleSubmit}>  {/* Optional wrapper */}
                <h1>Log Entry</h1>

                <label htmlFor="dayControl">Date</label>
                <input type="date" id="dayControl" defaultValue={logForm.dateInput} ref={dateRef} />

                <fieldset>
                    <legend>Category</legend>
                    <div ref={categoryRef} className="radio-group">
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

                <fieldset>
                    <legend>Sub-Category</legend>
                    <div ref={subCategoryRef} className="radio-group">
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
                <textarea id="content" ref={contentRef} placeholder="Write your note here..." />
                {errors.content && <div style={{ color: "red" }}>{errors.content}</div>}
                <button type="submit">Submit</button>
            </form>
        </>
    )
}
export default LogForm