function appendToStageView(element) {
    let stageViewPluginRect = document.querySelector('.table-viewPort').getBoundingClientRect();

    element.style.position = 'fixed';
    element.style.display = 'block';
    element.style.left = stageViewPluginRect.right + 2 + 'px';
    element.style.top = stageViewPluginRect.top + 'px';
}

export function alignWithStageViewPlugin(element) {
    const interval = setInterval(() => {
        try {
            appendToStageView(element);
            window.addEventListener('scroll', () => appendToStageView(element));
            window.addEventListener('resize', () => appendToStageView(element));
            clearInterval(interval);
        } catch (e) {
        }
    }, 200);
}