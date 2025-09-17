import './LogForm.css';
import { useState } from 'react';

function LogForm(props) {
    const { onEntry } = props;
    const now = new Date();
    const today = now.toISOString().split("T")[0];
    const timeNow = now.toTimeString().slice(0,5); 
    const [errors, setErrors] = useState({});
    const [isCurrentTime, setIsCurrentTime] = useState(false);
    const [timeValue, setTimeValue] = useState(timeNow);
    const [day, setDay] = useState(today);
    const [category, setCategory] = useState("");
    const [subCategory, setSubCategory] = useState("");
    const [content, setContent] = useState("");
    const categoryItems = ["Thoughts", "Actions", "Questions", "Observations", "Ideas", "Follow-Up", "Discoveries", "References"];
    const subCategoryItems = ["Food", "Physical Activity", "Glucose Reading", "General", "Not Sure", "TV", "Games"];

    const validate = () => {
        const newErrors = {};
        if (!content.trim()) {
            newErrors.content = "Description required";
        }

        if (!subCategory) {
            newErrors.subCat = "Sub-category is required";
        }

        if (!category) {
            newErrors.category = "Category is required";
        }
        return newErrors;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        let newErrors = validate();
        setErrors(newErrors);
        let entry = { day: day, category: category, subCategory: subCategory, content: content ,time:timeValue};
        onEntry(entry);
    };
    return (
        <>
            <div className="form-wrapper">
                <h2>Log Entry</h2>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="date">Date</label>
                    <input type="date" id="date" value={day} onChange={(e) => setDay(e.target.value)} />

                    <label>Category</label>
                    <div className="radio-group">
                        {categoryItems.map((item) => (
                            <label key={item} className="radio-label">
                                <input
                                    type="radio"
                                    name="category"
                                    value={item}
                                    checked={category === item}
                                    onChange={(e) => setCategory(e.target.value)}
                                />
                                {item}</label>))}
                    </div>
                    {errors.category && <div style={{ color: "red" }}>{errors.category}</div>}
                    <label>Sub-Category</label>
                    <div className="radio-group">
                        {subCategoryItems.map((item) => (
                            <label key={item} className="radio-label">
                                <input
                                    type="radio"
                                    name="subcategory"
                                    value={item}
                                    checked={subCategory === item}
                                    onChange={(e) => setSubCategory(e.target.value)}
                                />
                                {item}</label>))}
                    </div>
                    {errors.subCat && <div style={{ color: "red" }}>{errors.subCat}</div>}
                    <label htmlFor="desc">Description</label>
                    <textarea id="desc" rows="4" onChange={(e) => setContent(e.target.value)} placeholder="Write your note here..."></textarea>
                    {errors.content && <div style={{ color: "red" }}>{errors.content}</div>}
                    <div className='group-inputs'>
                        <label htmlFor="timeOfTheDay">Not Current Time?
                        <input type="checkbox" id="isCurrentTime" onChange={(e) => setIsCurrentTime(e.target.value)}></input>
                        <input type="time" id="timeValue" onChange={(e) => setTimeValue(e.target.value)} value={timeNow} disabled={isCurrentTime?false:true}/>
                        </label>
                    </div>
                    <button type="submit">Submit</button>
                </form>
            </div>
        </>
    )
}

export default LogForm