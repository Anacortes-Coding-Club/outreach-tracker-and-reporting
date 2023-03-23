const fs = require("fs");

function parseVisit(visit, date) {
  const parts = visit.split(/\n(.*)/s);
  const name = parts[0].split(",");
  const notes = parts[1];
  const regexp = /#[\w\/]+/g;
  const hashtags = [...notes.matchAll(regexp)].map((m) => m[0]);
  const visitObj = { date, name, hashtags, notes };
  return visitObj;
}

function parseTrip(trip) {
  // https://stackoverflow.com/questions/4607745/split-string-only-on-first-instance-of-specified-character
  const parts = trip.split(/\n(.*)/s);
  parts[0].replace("# ", "");
  const date = new Date(parts[0]);
  const visitsMarkdown = parts[1].split("\n### ");
  const visits = new Array();
  for (let visitMd of visitsMarkdown) {
    visitMd = visitMd.trim();
    if (visitMd) {
      visits.push(parseVisit(visitMd, date));
    }
  }
  return visits;
}

function parseFile() {
  const markdown = fs.readFileSync("input/sample.md", "utf8");
  const trips = markdown.split("\n# ");
  const visits = new Array();
  for (const trip of trips) {
    if (!trip) continue;
    const tripVisits = parseTrip(trip);
    visits.push(...tripVisits);
  }
  return visits;
}

const visits = parseFile();
console.log("Loaded visits:", visits.length);

// serialize
const filename = "visits_js.json";
fs.writeFileSync(filename, JSON.stringify(visits));
console.log("Wrote", filename);

// deserialize
const json = fs.readFileSync(filename, "utf8");
const visitsDeserialized = JSON.parse(json);
console.log("And read back visits:", visitsDeserialized.length);
