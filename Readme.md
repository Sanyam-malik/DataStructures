# Problem Metadata Specification

This repository supports structured metadata for coding problems using XML-style tags inside a `<metadata></metadata>` block.

The metadata is designed to be:
- machine-readable
- easy to edit manually
- git-friendly
- extensible

---

# Metadata Format

Each problem file can contain a metadata section like this:

```xml
<metadata>

    <Name>Two Sum</Name>

    <Path>arrays/two_sum.py</Path>

    <Description>
        Find two numbers that add up to target.
    </Description>

    <Status>Solved</Status>

    <URL>
        https://leetcode.com/problems/two-sum/
    </URL>

    <Notes>
        Use hashmap for O(n) solution.
    </Notes>

    <Date>2026-05-11</Date>

    <Level>Easy</Level>

    <Companies>Google:Amazon:Meta</Companies>

    <Concepts>HashMap:Arrays</Concepts>

    <Remarks>
        Classic Problem:Frequently Asked
    </Remarks>

    <SubDirectory>arrays</SubDirectory>

    <SheetItemStatus>true</SheetItemStatus>

    <CountInclusion>true</CountInclusion>

</metadata>
```

---

# Supported Fields

| Field | Type | Description |
|---|---|---|
| `Name` | String | Problem name |
| `Path` | String | Relative path to solution file |
| `Description` | String | Short problem description |
| `Status` | String | Current status |
| `URL` | String | Original problem URL |
| `Notes` | String | Personal notes |
| `Date` | String (`YYYY-MM-DD`) | Date added |
| `Level` | String | Difficulty level |
| `Companies` | Multi-value String | Companies asking this question |
| `Concepts` | Multi-value String | Concepts/topics used |
| `Remarks` | Multi-value String | Additional comments |
| `SubDirectory` | String | Logical grouping/folder |
| `SheetItemStatus` | Boolean | Whether active in sheet tracking |
| `CountInclusion` | Boolean | Whether included in statistics/counts |

---

# Multi-Value Fields

The following fields support multiple values separated using `:`.

- `Companies`
- `Concepts`
- `Remarks`

---

## Companies

```xml
<Companies>Google:Amazon:Meta</Companies>
```

---

## Concepts

```xml
<Concepts>HashMap:Arrays:Two Pointers</Concepts>
```

---

## Remarks

```xml
<Remarks>Classic Problem:Frequently Asked:Good For Revision</Remarks>
```

---

# Parsing Behavior

The parser will:

- split multi-value fields using `:`
- trim whitespace
- normalize company names to title case
- preserve ordering

Example:

```xml
<Companies>google:amazon:meta</Companies>
```

Stored as:

```text
Google:Amazon:Meta
```

---

# Boolean Fields

The following fields should use lowercase boolean values:

```xml
true
false
```

Supported boolean fields:
- `SheetItemStatus`
- `CountInclusion`

---

# Date Format

Dates should follow:

```xml
<Date>2026-05-11</Date>
```

Format:

```text
YYYY-MM-DD
```

---

# Recommended Status Values

```text
Solved
Pending
Revisit
Optimized
Incomplete
```

---

# Recommended Difficulty Levels

```text
Easy
Medium
Hard
```

---

# Minimal Example

```xml
<metadata>

    <Name>Binary Search</Name>

    <Status>Solved</Status>

    <Level>Easy</Level>

</metadata>
```

---

# Notes

- Metadata tags are case-sensitive.
- Unknown tags are ignored by the parser.
- Missing fields default to `None`.
- Boolean fields default to `True` when unspecified.
- Multi-value fields use `:` as separator.
- Paths are normalized during repository parsing.

---

# Recommended Repository Structure

```text
arrays/
    two_sum.py

dynamic_programming/
    longest_common_subsequence.py

graphs/
    dijkstra.py
```

---

# Example Problem File

```python
"""
<metadata>

    <Name>Two Sum</Name>

    <Description>
        Find indices of two numbers that add up to target.
    </Description>

    <Status>Solved</Status>

    <Level>Easy</Level>

    <Companies>Google:Amazon:Meta</Companies>

    <Concepts>HashMap:Arrays</Concepts>

    <Remarks>Classic Problem</Remarks>

</metadata>
"""

class Solution:
    pass
```