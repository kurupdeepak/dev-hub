import config from "../config";
const ENTRY_SERVICE_ENDPOINT = config.API_BASE_URL + "/trame/v1/entries"
export async function createEntry(entry) {
  console.log(ENTRY_SERVICE_ENDPOINT)
  const response = await fetch(`${ENTRY_SERVICE_ENDPOINT}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(entry)
  }).then(response => {
    if (!response.ok) {
      throw new Error("Failed to save entry");
    }
    return response.json();
  })
    .then(data => {
      console.log("Success:", data);
      // alert("Entry saved!");
    })
    .catch(error => {
      console.error("Error:", error);
      alert("Failed to save entry.");
    });;

  if (!response.ok) {
    throw new Error("Failed to create entry");
  }

  return response.json(); // return saved entry
}

export async function fetchEntries(entryId) {
  const response = await fetch(`${ENTRY_SERVICE_ENDPOINT}/${entryId}`);

  if (!response.ok) {
    throw new Error("Failed to fetch entries");
  }

  return response.json();
}

// Add other methods: updateEntry, deleteEntry, etc.