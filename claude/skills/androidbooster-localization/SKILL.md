---
name: androidbooster-localization
description: Handles translations for AndroidBooster string resources. Use when adding, changing, or removing strings in any strings.xml or plurals.xml, or when creating new locale resource directories.
---

# AndroidBooster Localization

## When This Applies

After any change to a `strings.xml` (or `plurals.xml`) in a `values/` directory, check whether the same module has locale-specific directories (e.g. `values-es/`, `values-ja/`, `values-de/`). If locale directories exist, propagate the change to every locale's `strings.xml`.

If no locale directories exist for the module, no translation work is needed.

## String Resource Locations

Each module may have its own string resources:

| Module | Path prefix |
|--------|------------|
| `app` | `app/src/main/res/` |
| `core:ui` | `core/ui/src/main/res/` |

Check for locale directories with: `values-<locale>/strings.xml` under the same `res/` path.

## Translation Rules

### Contextual Translation

Translate based on **how the string is used in the UI**, not word-for-word. Before translating:

1. Search the codebase for where the string resource is referenced (e.g. `R.string.<name>` or `@string/<name>`)
2. Understand the UI context — is it a button label, dialog title, error message, placeholder, menu item, etc.?
3. Choose the translation that a native speaker would expect in that UI context

**Example — button label:**
```xml
<!-- Default (values/strings.xml) -->
<string name="action_got_it">Got it</string>

<!-- Spanish (values-es/strings.xml) — contextual, not literal -->
<string name="action_got_it">Entendido</string>

<!-- Japanese (values-ja/strings.xml) -->
<string name="action_got_it">了解</string>
```

**Example — error message:**
```xml
<!-- Default -->
<string name="error_connection">Something went wrong. Check your connection.</string>

<!-- Spanish — natural phrasing for an error -->
<string name="error_connection">Algo salió mal. Revisa tu conexión.</string>

<!-- Japanese -->
<string name="error_connection">エラーが発生しました。接続を確認してください。</string>
```

### Android strings.xml Formatting Rules

1. **Escape single quotes** with a backslash:
```xml
<string name="welcome">It\'s a great day</string>
```

2. **Escape double quotes** with a backslash, or wrap the entire string in single quotes:
```xml
<string name="quote">\"Hello,\" she said</string>
```

3. **Preserve HTML markup** — if the default string contains HTML tags, duplicate them in translations:
```xml
<!-- Default -->
<string name="terms">By continuing, you agree to our <b>Terms</b> and <i>Privacy Policy</i>.</string>

<!-- Spanish — HTML tags preserved -->
<string name="terms">Al continuar, aceptas nuestros <b>Términos</b> y la <i>Política de Privacidad</i>.</string>
```

4. **Preserve format specifiers** — keep `%s`, `%d`, `%1$s`, `%2$d`, etc. in the same logical positions:
```xml
<!-- Default -->
<string name="greeting">Hello, %1$s! You have %2$d messages.</string>

<!-- Spanish -->
<string name="greeting">¡Hola, %1$s! Tienes %2$d mensajes.</string>
```

5. **Preserve `\n` and `\t`** escape sequences as-is.

6. **CDATA sections** — if the default uses `<![CDATA[...]]>`, the translation must too.

### Plurals

When adding or modifying `<plurals>` entries, respect each locale's plural rules. Different languages have different plural categories.

**English** uses `one` and `other`:
```xml
<plurals name="item_count">
    <item quantity="one">%d item</item>
    <item quantity="other">%d items</item>
</plurals>
```

**Russian** uses `one`, `few`, `many`, and `other`:
```xml
<plurals name="item_count">
    <item quantity="one">%d элемент</item>
    <item quantity="few">%d элемента</item>
    <item quantity="many">%d элементов</item>
    <item quantity="other">%d элементов</item>
</plurals>
```

**Japanese/Chinese/Korean** — typically only `other` (no grammatical plural):
```xml
<plurals name="item_count">
    <item quantity="other">%d 件</item>
</plurals>
```

**Arabic** uses `zero`, `one`, `two`, `few`, `many`, and `other`:
```xml
<plurals name="item_count">
    <item quantity="zero">لا عناصر</item>
    <item quantity="one">عنصر واحد</item>
    <item quantity="two">عنصران</item>
    <item quantity="few">%d عناصر</item>
    <item quantity="many">%d عنصرًا</item>
    <item quantity="other">%d عنصر</item>
</plurals>
```

**Polish** uses `one`, `few`, `many`, and `other`:
```xml
<plurals name="item_count">
    <item quantity="one">%d element</item>
    <item quantity="few">%d elementy</item>
    <item quantity="many">%d elementów</item>
    <item quantity="other">%d elementu</item>
</plurals>
```

Refer to the [CLDR plural rules](https://www.unicode.org/cldr/charts/latest/supplemental/language_plural_rules.html) when unsure about a locale's required categories.

### String Arrays

For `<string-array>` entries, translate each `<item>` while keeping the same count and order:
```xml
<!-- Default -->
<string-array name="sort_options">
    <item>Name</item>
    <item>Date</item>
    <item>Size</item>
</string-array>

<!-- Spanish -->
<string-array name="sort_options">
    <item>Nombre</item>
    <item>Fecha</item>
    <item>Tamaño</item>
</string-array>
```

## Workflow

When a `strings.xml` change is made:

1. **Identify the module** — determine which module's `res/` directory was changed
2. **Check for locale directories** — look for `values-<locale>/` siblings under the same `res/` path
3. **If locale directories exist**, for each locale:
   - Find the usage context by searching for `R.string.<name>` or `@string/<name>` in layouts/code
   - Produce a contextual translation
   - Apply all formatting rules (escaping, HTML, format specifiers, plural categories)
   - Add the translated string to the locale's `strings.xml`, maintaining the same grouping comments and ordering as the default
4. **If a string was removed** from the default, remove it from all locale files too
5. **If a string was modified** in the default, update all locale translations accordingly

## Do Not Translate

- `translatable="false"` strings — skip these entirely
- String names that are explicitly marked as non-translatable via `tools:ignore="MissingTranslation"`
- Raw resource references or format-only strings (e.g. `<string name="url_format">https://%s</string>`)
