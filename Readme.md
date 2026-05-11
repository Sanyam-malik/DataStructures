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

    <name>Two Sum</name>

    <path>arrays/two_sum.py</path>

    <description>
        Find two numbers that add up to target.
    </description>

    <status>Solved</status>

    <url>
        https://leetcode.com/problems/two-sum/
    </url>

    <notes>
        Use hashmap for O(n) solution.
    </notes>

    <date>2026-05-11</date>

    <level>Easy</level>

    <companies>Google:Amazon:Meta</companies>

    <concepts>HashMap:Arrays</concepts>

    <remarks>
        Classic Problem:Frequently Asked
    </remarks>

    <subdirectory>arrays</subdirectory>

    <sheetitemstatus>true</sheetitemstatus>

    <countinclusion>true</countinclusion>

</metadata>
```

---

# Supported Fields

| Field | Type | Description |
|---|---|---|
| `name` | String | Problem name |
| `path` | String | Relative path to solution file |
| `description` | String | Short problem description |
| `status` | String | Current status |
| `url` | String | Original problem URL |
| `notes` | String | Personal notes |
| `date` | String (`YYYY-MM-DD`) | Date added |
| `level` | String | Difficulty level |
| `companies` | Multi-value String | Companies asking this question |
| `concepts` | Multi-value String | Concepts/topics used |
| `remarks` | Multi-value String | Additional comments |
| `subdirectory` | String | Logical grouping/folder |
| `sheetitemstatus` | Boolean | Whether active in sheet tracking |
| `countinclusion` | Boolean | Whether included in statistics/counts |

---

# Multi-Value Fields

The following fields support multiple values separated using `:`.

- `companies`
- `concepts`
- `remarks`

---

## Companies

```xml
<companies>Google:Amazon:Meta</companies>
```

---

## Concepts

```xml
<concepts>HashMap:Arrays:Two Pointers</concepts>
```

---

## Remarks

```xml
<remarks>Classic Problem:Frequently Asked:Good For Revision</remarks>
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
<companies>google:amazon:meta</companies>
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
- `sheetitemstatus`
- `countinclusion`

---

# Date Format

Dates should follow:

```xml
<date>2026-05-11</date>
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

    <name>Binary Search</name>

    <status>Solved</status>

    <level>Easy</level>

</metadata>
```

---

# Notes

- Metadata tags are case-sensitive.
- All metadata tags should be lowercase.
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

    <name>Two Sum</name>

    <description>
        Find indices of two numbers that add up to target.
    </description>

    <status>Solved</status>

    <level>Easy</level>

    <companies>Google:Amazon:Meta</companies>

    <concepts>HashMap:Arrays</concepts>

    <remarks>Classic Problem</remarks>

</metadata>
"""

class Solution:
    pass
```